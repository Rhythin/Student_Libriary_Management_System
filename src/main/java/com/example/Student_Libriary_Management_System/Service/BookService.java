package com.example.Student_Libriary_Management_System.Service;

import com.example.Student_Libriary_Management_System.Models.Author;
import com.example.Student_Libriary_Management_System.Models.Book;
import com.example.Student_Libriary_Management_System.Repository.AuthorRepository;
import com.example.Student_Libriary_Management_System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public String addBook(Book book){

        try {
            int authorId = book.getAuthor().getId();
            Author author = authorRepository.findById(authorId).get();

            book.setAuthor(author);
            author.getBooksWritten().add(book);

            //only save author as book gets saved due to bidirectional mapping cascade effect
            authorRepository.save(author);
        }
        catch (Exception e){
            return e.toString();
        }
        return "book created and with given author";
    }
}
