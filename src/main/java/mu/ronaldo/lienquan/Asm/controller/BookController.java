package mu.ronaldo.lienquan.Asm.controller;

import mu.ronaldo.lienquan.Asm.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import mu.ronaldo.lienquan.Asm.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@RestController public class BookController {@Autowired private BookService bookService;
    @GetMapping(value = "/")
    public String Welcome(){
        return "Welcome back";
    }
    @GetMapping("/books") public List<Book> GetAll() {
        return bookService.getAll();
    }
    @GetMapping("/books/{id}") public Book get(@PathVariable int id)
    {
        return bookService.get(id);
    }
    @PostMapping("/books") public Book create(@RequestBody
                                              Book book)
    {
        bookService.add(book);
        return book;
    }
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id)
    {
        bookService.remove(id);
    }
}
