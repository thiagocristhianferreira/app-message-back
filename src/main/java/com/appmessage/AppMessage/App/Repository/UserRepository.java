package com.appmessage.AppMessage.App.Repository;

import com.appmessage.AppMessage.App.DTO.UserRegistrationDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegistrationDTO, Long> {
}
