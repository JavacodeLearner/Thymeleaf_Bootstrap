package com.Aries.Thymeleaf_Bootstrap.Controller;


import com.Aries.Thymeleaf_Bootstrap.Entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class MyController {

    List<Book> books = new ArrayList<>(List.of(
            new Book(1, "Maths", "Gautam"),
            new Book(2, "Science", "Sheela"),
            new Book(3, "Computer", "Raju")
    ));


    @GetMapping("/booklist")
    public String hello(Model model) {
        model.addAttribute("book", books);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
            }
        }
        return "redirect:/booklist";
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Book book = null;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                book = books.get(i);
                break;
            }
        }
        if (book != null) {
            model.addAttribute("book", book);
            System.out.println("check this output" + book.getId() + book.getTitle() + book.getAuthor());


        }
        return "editform";
    }

    @PostMapping("/editupdate")
    public String editupdate(@ModelAttribute Book book, Model model) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.get(i).setTitle(book.getTitle());
                books.get(i).setAuthor(book.getAuthor());
                break;
            }

        }
        if (book != null) {
            model.addAttribute("book", book);
        }
        return "redirect:/booklist";
    }

    @PostMapping("/bookdetails")
    public String book(@ModelAttribute Book book, Model model) {

            book.setId(books.size() + 1);
            books.add(book);
            model.addAttribute("mbook", book);
            return "redirect:/booklist";
        }

    }

