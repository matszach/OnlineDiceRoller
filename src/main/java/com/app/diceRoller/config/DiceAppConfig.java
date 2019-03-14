package com.app.diceRoller.config;

import com.app.diceRoller.util.ViewNames;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class DiceAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // sets default home view ("localhost:8080")
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

}
