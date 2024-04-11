package com.example.co_templates.quests.Services;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class QuestBoardService {
    public ArrayList<HashMap<String,Object>> list(Integer pageNumber){
        ArrayList<HashMap<String, Object>> boardList = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> boarditem = new HashMap<>();
        boarditem.put("PK_ID", 1);
        boarditem.put("TITLE", "파묘");
        boarditem.put("CONTENT", "끝내줘요");
        boardList.add(boarditem);
    
        boarditem = new HashMap<>();
        boarditem.put("PK_ID", 2);
        boarditem.put("FK_ID", "파묘");
        boarditem.put("NAME", "이건 뭥미?");
        boardList.add(boarditem);

        return boardList;
    }
}
