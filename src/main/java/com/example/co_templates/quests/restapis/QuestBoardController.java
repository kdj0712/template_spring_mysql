package com.example.co_templates.quests.restapis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.co_templates.quests.Services.QuestBoardService;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class QuestBoardController {

    @Autowired QuestBoardService boardService;
    @GetMapping("/q/r/board/list/{pageNumber}")
    public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable("pageNumber") Integer pageNumber) {
        ArrayList<HashMap<String, Object>> boardList = new ArrayList<HashMap<String, Object>>();
        boardList = boardService.list(pageNumber);
        
        return  ResponseEntity.ok().body(boardList);
    }

    @GetMapping("/q/r/board/view/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> view(@PathVariable("pk_id") String pkId) {
        HashMap<String, Object> contentdetail = new HashMap<>();
        contentdetail = boardService.view(pkId);

        return ResponseEntity.ok().body(contentdetail);
    }

    @Autowired QuestBoardService insertboard;
    @PostMapping("/q/r/board/view/{title}/{content}")
    public ResponseEntity<HashMap<String, Object>> insert(@PathVariable("title") String title,
                                                    @PathVariable("content") String content) {

        int pkId = insertboard.insert(title, content);
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("pkId", pkId);
    
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/q/r/board/list/delete/{pk_id}")
    public ResponseEntity<HashMap<Boolean,Boolean>> delete(@PathVariable("pk_id") String pkId) {
        HashMap<Boolean, Boolean> boarddelete = boardService.delete(pkId);

        return ResponseEntity.ok(boarddelete);
    }

    
    @GetMapping("/q/r/board/mixed/{pageNumber}/{pk_id}/{title}/{content}")
    public ResponseEntity<HashMap<String, Object>> Mixed (@PathVariable("pageNumber") Integer pageNumber
                                                        , @PathVariable("pk_id")String pkid
                                                        , @PathVariable("title")String title
                                                        , @PathVariable("content")String content) {
        // call service
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap = boardService.mixed(pageNumber, pkid,title,content);

        // add request params
        HashMap<String,Object> requestParams = new HashMap<>();
        requestParams.put("pageNumber", pageNumber);
        requestParams.put("pk_id", pkid);
        requestParams.put("title", title);
        requestParams.put("title", content);
        resultMap.put("requestParams",requestParams);
        
        return ResponseEntity.ok().body(resultMap);
    }

}
