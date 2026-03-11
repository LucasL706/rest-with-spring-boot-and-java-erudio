package LucasL706.com.github.services;

import LucasL706.com.github.controllers.BookController;
import LucasL706.com.github.data.dto.BookDTO;
import LucasL706.com.github.exception.RequiredObjectIsNullException;
import LucasL706.com.github.exception.ResourceNotFoundException;
import LucasL706.com.github.model.Book;
import LucasL706.com.github.repository.BookRepository;
import static LucasL706.com.github.mapper.ObjectMapper.parseListObjects;
import static LucasL706.com.github.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    BookRepository repository;

    public BookDTO findById(Long id) {
        logger.info("Finding a book");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")); // Procura o ID no repositorio, se não achar gera excessao
        var dto = parseObject(entity, BookDTO.class); // Transforma entidade em DTO
        addHateoasLinks(dto);
        return dto;
    }

    public List<BookDTO> findAll() {
        logger.info("Finding all books");
        var books = parseListObjects(repository.findAll(), BookDTO.class); // Pega todos as entidades livros e transforma em livros DTOs
        books.forEach(this::addHateoasLinks); // Adiciona links Hateoas para todos os livros DTOs
        return books;
    }

    public BookDTO create(BookDTO bookDTO) {

        if (bookDTO == null){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Creating a book");

        var entity = parseObject(bookDTO, Book.class);

        var dto = parseObject(repository.save(entity), BookDTO.class);

        addHateoasLinks(dto);

        return dto;
    }

    public BookDTO update(BookDTO bookDTO) {
        if (bookDTO == null){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Updating a book");

        Book entity = repository.findById(bookDTO.getId()). orElseThrow( () -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setAuthor(bookDTO.getAuthor());
        entity.setLaunchDate(bookDTO.getLaunchDate());
        entity.setPrice(bookDTO.getPrice());
        entity.setTitle(bookDTO.getTitle());

        var dto = parseObject(entity, BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting a book");
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));

        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));

        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));

        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));

        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));

    }
}
