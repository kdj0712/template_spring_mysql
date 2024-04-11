package com.example.co_templates.quests.restapis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.co_templates.quests.Services.QuestBoardService;

@RestController
public class QuestBoardController {

    @Autowired QuestBoardService boardService;
    @GetMapping("/q/r/boardController/list/{pageNumber}")
    public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable("pageNumber") Integer pageNumber) {
        ArrayList<HashMap<String, Object>> boardList = new ArrayList<HashMap<String, Object>>();
        boardList = boardService.list(pageNumber);
        
        return  ResponseEntity.ok().body(boardList);
    }
}
