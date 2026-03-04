package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.bpa4j.core.Data.EditableGroup;
import com.bpa4j.core.ProgramStarter;
import com.bpa4j.core.Registrator;
import com.bpa4j.core.Root;
import com.bpa4j.core.User;
import com.bpa4j.core.User.Feature;
import com.bpa4j.core.User.Permission;
import com.bpa4j.core.User.Role;
import com.bpa4j.defaults.features.DefaultFeature;
import com.bpa4j.ui.PathIcon;
import com.ntoproject.editables.registered.Events;
import com.ntoproject.editables.registered.Exposition;
import com.ntoproject.editables.registered.Space;
import com.ntoproject.editables.registered.Studio;
import com.ntoproject.editables.registered.Teacher;
import com.ntoproject.editables.registered.TypeOfEvents;

public class Main {
    public enum AppRole implements Role{
        ENTERTAINMENT(
            ()->new Permission[]{AppPermission.CREATE_SPACE,AppPermission.READ_SPACE, AppPermission.CREATE_EVENTS,AppPermission.READ_EVENTS, AppPermission.CREATE_TYPEOFEVENTS,AppPermission.READ_TYPEOFEVENTS},
            ()->new Feature[]{
                DefaultFeature.MODEL_EDITING
            }
        ),
        CULTURE(
            ()->new Permission[]{AppPermission.READ_EXPOSITION,AppPermission.CREATE_EXPOSITION},
            ()->new Feature[]{
                DefaultFeature.MODEL_EDITING
            }
        ),
        EDUCATION(
            ()->new Permission[]{AppPermission.READ_TEACHER,AppPermission.CREATE_TEACHER,AppPermission.CREATE_STUDIO,AppPermission.READ_STUDIO},
            ()->new Feature[]{
                DefaultFeature.MODEL_EDITING
            }
        ),;
        private AppRole(Supplier<Permission[]>p,Supplier<Feature[]>f){
            SwingUtilities.invokeLater(()->Registrator.register(this,f.get(),p.get()));
        }
    }
    public enum AppPermission implements Permission{
        READ_EXPOSITION,
        CREATE_EXPOSITION,
        READ_SPACE,
        CREATE_SPACE,
        READ_STUDIO,
        CREATE_STUDIO,
        READ_TEACHER,
        CREATE_TEACHER,
        READ_EVENTS,
        CREATE_EVENTS,
        READ_TYPEOFEVENTS,
        CREATE_TYPEOFEVENTS
        ;
        private AppPermission(){Registrator.register(this);}
    }

    public static void main(String[]args){
        // new ProjectGraph(new File("C:\\Users\\user\\Desktop\\IT\\Java\\1C\\NTO training\\team\\T3\\ntoproject\\src\\main\\java")).show();
        // new ProjectGraph(new File("C:\\Users\\ice_d\\Desktop\\Моё\\Програмирование\\NTO training\\T3\\ntoproject\\src\\main\\java")).show();
        // Navigator.init();
        ProgramStarter.welcomeMessage="Добро пожаловать в центр \"ЗИЛ\", уважаемые эксперты!";
        ProgramStarter.authRequired=false;
        if(ProgramStarter.isFirstLaunch()){
            //Регистрация пользователей
            User.register("Развлечения","",AppRole.ENTERTAINMENT);
            User.register("Культура","",AppRole.CULTURE);
            User.register("Образование","",AppRole.EDUCATION);
            //Декларация групп
            EditableGroup<Exposition>expositions=new EditableGroup<>(
                new PathIcon("ui/order.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/order_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Exposition.class
            );
            EditableGroup<Space>spaces=new EditableGroup<>(
                new PathIcon("ui/product.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/product_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Space.class
            );
            EditableGroup<Studio>studios=new EditableGroup<>(
                new PathIcon("ui/factory.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/factory.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Studio.class
            );
            EditableGroup<Teacher>teachers=new EditableGroup<>(
                new PathIcon("ui/worker.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/worker_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Teacher.class
            );
            EditableGroup<Events>events=new EditableGroup<>(
                new PathIcon("ui/factory.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/factory.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                Events.class
            );
            EditableGroup<TypeOfEvents>typeOfEvents=new EditableGroup<>(
                new PathIcon("ui/order.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                new PathIcon("ui/order_add.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
                TypeOfEvents.class
            );            

            ProgramStarter.runProgram();
            //Регистрация групп
            Registrator.register(expositions,spaces,studios,teachers, events, typeOfEvents);
            //Тестовые данные
            //FIXME: fill test data
        }else ProgramStarter.runProgram();
    }
}