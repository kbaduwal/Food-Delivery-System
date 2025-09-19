package com.baduwal.ecommerce.service;

import com.baduwal.ecommerce.data.entity.User;
import com.baduwal.ecommerce.repo.UserRepository;
import com.baduwal.ecommerce.utils.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailUtil emailUtil;

    public static final int OTP_VALID_DURATION = 350;

    @Override
    public boolean registerUser(User user) {
        boolean userByName = findUserByName(user.getEmail()).isPresent();
        boolean userByEmail = findUserByEmail(user.getEmail()).isPresent();
        boolean userByPhone = findUserByPhone(user.getPhoneNumber()).isPresent();

        if (userByName || userByEmail || userByPhone) {
            return false;
        }

        //Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //Generate OTP once and reuse it.
        String otp = generateOtp();
        user.setOtp(otp);
        user.setTokenExpiration(generateOtpTime());
        user.setVerified(false);

        //Save user
        userRepository.save(user);
        //User use = createUser(user);

        //Send otp email
        String to = user.getEmail();
        String subject = "Reset Password OTP.";
        String body = "Your OTP for password reset is: " + otp + "\nValid for " + OTP_VALID_DURATION + " minutes.";
        emailUtil.sendEmail(to, subject, body);

        return true;
    }

    @Override
    public boolean verifyOtp(String email, String otp) {
        Optional<User> userByEmail = findUserByEmail(email);
        if(userByEmail.isPresent()) {
            User user = userByEmail.get();

            if (user.getOtp() !=null
                && user.getOtp().trim().equals(otp)
                && user.getTokenExpiration() != null
                && user.getTokenExpiration().isAfter(LocalDateTime.now())
            ) {
                //Mark as verified and clear otp
                user.setVerified(true);
                user.setOtp(null);
                user.setTokenExpiration(null);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setNewPassword(String email, String otp, String newPassword) {
        if(!verifyOtp(email, otp)) {
            return false;
        }
        Optional<User> userByEmail = findUserByEmail(email);
        if(userByEmail.isPresent()) {
            User user = userByEmail.get();
            user.setPassword(newPassword);
            user.setVerified(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public String changePassword(String oldPassword, String newPassword, User user) {
      try{
          // Find user by email
          Optional<User> userByEmail = findUserByEmail(user.getEmail());
          if(!userByEmail.isPresent()) {
              return "User not found";
          }

          User existingUser = userByEmail.get();

          //verify Password
          if (!passwordEncoder.matches(oldPassword, existingUser.getPassword())) {
              return "Invalid Old Password";
          }

          //Validate new password
          String validationResult = validatePasswordStrength(newPassword);
          if (!validationResult.equals("Valid")) {
              return validationResult;
          }

          // Check if new password is same as current password
          if(passwordEncoder.matches(newPassword, existingUser.getPassword())) {
              return "New password must be different from old password";
          }

          // Encode new password and update
          String encodedNewPassword = passwordEncoder.encode(newPassword);
          existingUser.setPassword(encodedNewPassword);
          userRepository.save(existingUser);
          return "Password changed successfully";
      }catch (Exception e){
          log.error("Error changing password for user: {}",user.getEmail(),e);
          return "Error changing password for user: ";
      }

    }

    private Optional<User> findUserByName(String email) {
        return userRepository.findByEmail(email);
    }

    private Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private Optional<User> findUserByPhone(String phone) {
        return userRepository.findByPhoneNumber(phone);
    }

    private User createUser(User user) {
        return userRepository.save(user);
    }

    private String generateRandomPassword() {
        return "123456";
    }

    private String generateOtp() {
        return String.format("%06d",new Random().nextInt(999999));
    }

    private LocalDateTime generateOtpTime() {
        return LocalDateTime.now().plusMinutes(OTP_VALID_DURATION);
    }

    public static String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String validatePasswordStrength(String password) {
        if (password == null || password.trim().isEmpty()) {
            return "Password cannot be empty";
        }

        if (password.length() < 8){
            return "Password must be at least 8 characters";
        }

        if(password.length() > 20){
            return "Password must not exceed 20 characters";
        }

        //Check for uppercase letter
        if(!password.matches(".*[A-Z].*")){
            return "Password must contain at least one uppercase letter.";
        }

        //Check for lowercase
        if(!password.matches(".*[a-z].*")){
            return "Password must contain at least one lowercase letter.";
        }

        //Check for digit
        if (!password.matches(".*\\d.*")){
            return "Password must contain at least one digit.";
        }

        //Check for special character
        if (!password.matches(".*[@$!%*&].*")){
            return "Password must contain at least one special character.";
        }

        //Check for common weak password
        String[] commonPasswords = {
                "password","12345678","qwerty","abc123","password123",
                "admin","letmein","welcome","money","dragon"
        };

        String lowerPassword = password.toLowerCase();
        for (String common : commonPasswords){
            if (lowerPassword.contains(common)){
                return "Password is too common. Please choose a strong password.";
            }
        }

        return "Valid";
    }



}
