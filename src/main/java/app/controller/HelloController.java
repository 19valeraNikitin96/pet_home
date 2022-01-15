package app.controller;

import app.Application;
import app.controller.model.StudentJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Application.StudentDatabaseService studentDatabaseService;

    @GetMapping("/1")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @DeleteMapping("/2")
    public String index2() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/students/{studentId}")
    public StudentJSON getStudent(@PathVariable Integer studentId) {
        return studentDatabaseService.getStudent(studentId);
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Integer studentId) {
        studentDatabaseService.deleteStudent(studentId);
        return ResponseEntity.ok("Ok");
    }

    @PostMapping("/students")
    public ResponseEntity createStudent(@RequestBody StudentJSON json) {
        int student_id = studentDatabaseService.createStudent(json);
        Object obj = new Object(){
            {
                setId(student_id);
            }

            private Integer id;

            public void setId(Integer id){
                this.id = id;
            }

            public Integer getId(){
                return this.id;
            }
        };
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity updateStudent(@PathVariable Integer studentId, @RequestBody StudentJSON json) {
        try {
            studentDatabaseService.updateStudent(studentId, json);
        } catch (RuntimeException e){
            Object obj = new Object(){
                {
                    setErrorMsg(e.getMessage());
                }

                private String errorMsg;

                public void setErrorMsg(String errorMsg){
                    this.errorMsg = errorMsg;
                }

                public String getErrorMsg(){
                    return this.errorMsg;
                }
            };
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
        }
        return ResponseEntity.ok("Ok");
    }
}
