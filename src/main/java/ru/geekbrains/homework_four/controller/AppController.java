package ru.geekbrains.homework_four.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.homework_four.model.User;
import ru.geekbrains.homework_four.service.AppService;


@Controller
public class AppController {

    /**
     * Обработчик простой статической страницы сайта- "Привет МИР"
     *
     * @return "index.html"
     */
    @GetMapping("/hello")
    public String hello() {
        return "index.html";
    }


    /**
     * Обработчик страницы с некоторыми переменными об имени пользователя и его возрасте,
     * которые заполняются с помощью модели Spring MVC и отображаются на странице
     * с использованием Thymeleaf.
     *
     * @return "userInfo.html"
     */
    @RequestMapping("/userInfo")
    public String helloUser(Model model) {
        model.addAttribute("userName", "Vladislav");
        model.addAttribute("userAge", 51);
        return "userInfo.html";
    }


    /**
     * Обработчик страницы с формой ввода, использует Thymeleaf для рендеринга формы.
     * Далее контроллер Spring MVC, обрабатывает отправку формы и выводит полученные данные.
     * @return "users.html"
     */

    @Autowired
    private AppService appService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        var user = appService.findAll();
        model.addAttribute("users", appService.getAllUsers());
        return "users.html";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {
        appService.addUser(user);
        var users = appService.findAll();
        model.addAttribute("products", users);
        return getUsers(model);
    }

}

