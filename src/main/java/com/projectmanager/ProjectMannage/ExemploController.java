package com.projectmanager.ProjectMannage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ExemploController 
{
    @GetMapping("/ok") 
    public ResponseEntity<String> sayOk()
    {
        return ResponseEntity.ok("recebido Ok!");
    }

    @PostMapping("/echo")
    public ResponseEntity<String>echo(@RequestBody String value){
        StringBuilder sb = new StringBuilder(value);
        return ResponseEntity.ok(sb.reverse().toString());
    }
  
}
