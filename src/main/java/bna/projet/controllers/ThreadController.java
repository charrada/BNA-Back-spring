package bna.projet.controllers;

import bna.projet.Repository.ThreadRepository;
import bna.projet.Services.ThreadServiceImpl;
import bna.projet.entities.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Thread")
public class ThreadController {

    @Autowired
    ThreadRepository rr;
    @Autowired
    ThreadServiceImpl ThreadService;


    @GetMapping("/")
    public List<Thread> findThreadList(){

     return (List<Thread>) rr.findAll1();

       /* List<Thread> list=new ArrayList<>();
        for (Iterator<Thread> i = rr.findAll().iterator(); i.hasNext();) {
            Thread item = i.next();
            if (item.getEtudiant()!=null){
                list.add(item);
            }
        }
        return new ResponseEntity <List<Thread>>(list, HttpStatus.OK);*/
    }


    @GetMapping("/{id}")
    public ResponseEntity<Thread> findThreadById(@PathVariable Long id) {

        return new ResponseEntity <>(ThreadService.findThreadById(id), HttpStatus.FOUND);
    }

    @GetMapping("et/{id}")
    public ResponseEntity<String> findEtName(@PathVariable Long id) {

        return new ResponseEntity <>(ThreadService.etudiantByName(id), HttpStatus.FOUND);
    }

    @GetMapping("like2/{id}/{ide}")
    public Thread tLike(@PathVariable Long id,@PathVariable long ide) {

        return ThreadService.like(id,(long) ide);

    }

    @GetMapping("like/{idt}/{ide}")
    public boolean tLike1(@PathVariable long idt, @PathVariable long ide) {

        return ThreadService.likedThread((long)idt,(long)ide);

    }

    @PostMapping("/AddThread")
    public ResponseEntity<Thread> AddThread(@RequestBody Thread Thread){

        System.out.println(Thread);
        return new ResponseEntity<>(ThreadService.addThread(Thread), HttpStatus.CREATED);

    }

    @PostMapping("/updateThread")
    public Thread updateThread(@RequestBody Thread Thread){
        return ThreadService.updateThread(Thread);
    }
    @GetMapping("/deleteThread/{id}")
    public ResponseEntity<?> deleteDepartment( @PathVariable Long id) {
        ThreadService.deleteThread(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
