package com.ntoproject;

import java.io.File;
import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.bpa4j.core.Navigator;
import com.bpa4j.core.ProgramStarter;
import com.bpa4j.core.Registrator;
import com.bpa4j.core.User.Feature;
import com.bpa4j.core.User.Permission;
import com.bpa4j.core.User.Role;
import com.bpa4j.util.codegen.ProjectGraph;

public class Main {
    public enum AppRole implements Role{
        ENTERTAINMENT(
            ()->new Permission[]{},
            ()->new Feature[]{}
        ),
        CULTURE(
            ()->new Permission[]{},
            ()->new Feature[]{}
        ),
        EDUCATION(
            ()->new Permission[]{},
            ()->new Feature[]{}
        ),;
        private AppRole(Supplier<Permission[]>p,Supplier<Feature[]>f){
            SwingUtilities.invokeLater(()->Registrator.register(this,f.get(),p.get()));
        }
    }
    public enum AppPermission implements Permission{
        ;
        private AppPermission(){Registrator.register(this);}
    }

    public static void main(String[] args) {
        // new ProjectGraph(new File("C:\\Users\\user\\Desktop\\IT\\Java\\1C\\NTO training\\team\\T3\\ntoproject\\src\\main\\java")).show();
        // new ProjectGraph(new File("C:\\Users\\ice_d\\Desktop\\Моё\\Програмирование\\NTO training\\T3\\ntoproject\\src\\main\\java")).show();
        Navigator.init();
        ProgramStarter.welcomeMessage="Добро пожаловать в центр \"ЗИЛ\", уважаемые эксперты!";
        ProgramStarter.authRequired=false;
        if(ProgramStarter.firstLaunch){
            //Регистрация пользователей
            
            //Декларация групп
            
            ProgramStarter.runProgram();
            //Регистрация групп
            
            //Тестовые данные
            
        }else ProgramStarter.runProgram();
    }
}