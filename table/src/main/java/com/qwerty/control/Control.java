package com.qwerty.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Control {

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public ModelAndView table(){
        ModelAndView view = new ModelAndView();
        view.addObject("men", men);
        return view;
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
    public String deleteMan(@PathVariable("name") String line) {
        List<Person> list = new ArrayList<>();
        String name = line.substring(0, line.indexOf("+"));
        String surname = line.substring(line.indexOf("+")+1, line.length());
        for (Person man: men) {
            if (name.compareTo(man.getName()) == 0 && surname.compareTo(man.getSurname()) == 0) {
                continue;
            }
            list.add(man);
        }
        men.clear();
        men.addAll(list);
        return "redirect:/table";
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public String refresh(){
        men = setList();
        return "redirect:/table";
    }

    static List<Person> men = setList();

    private static List<Person> setList() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Harry", "Potter"));
        list.add(new Person("Iosif", "Stalin"));
        list.add(new Person("Bill", "Gates"));
        list.add(new Person("Charles", "Darwin"));
        list.add(new Person("Ilya", "Muromets"));
        list.add(new Person("Lev", "Tolstoy"));
        list.add(new Person("Yuriy", "Gagarin"));
        return list;
    }
}
