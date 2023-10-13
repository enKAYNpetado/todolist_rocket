package br.com.PauloVictor.todolist.controller;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
//sinal de maior e menor significa que a classe vai receber generators
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
     UserModel findByUsername(String username);
}
