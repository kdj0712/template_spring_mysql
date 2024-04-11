package com.example.co_templates.quests.Services;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class QuestBoardService {
    private ArrayList<HashMap<String, Object>> boardList = new ArrayList<>(); // 게시글 리스트를 관리하는 멤버 변수

    public ArrayList<HashMap<String,Object>> list(Integer pageNumber){
        ArrayList<HashMap<String, Object>> boardList = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> boarditem = new HashMap<>();
        boarditem.put("PK_ID", 1);
        boarditem.put("TITLE", "파묘");
        boarditem.put("CONTENT", "끝내줘요");
        boardList.add(boarditem);
    
        boarditem = new HashMap<>();
        boarditem.put("PK_ID", 2);
        boarditem.put("TITLE", "파묘");
        boarditem.put("CONTENT", "이건 뭥미?");
        boardList.add(boarditem);

        return boardList;
    }

    public HashMap<String, Object> view(String pkId){
        HashMap<String, Object> contentdetail = new HashMap<>();

        String title = "파묘";
        String content = "아카데미 가야한다.";
        contentdetail.put("PK_ID", pkId);
        contentdetail.put("TITLE", title);
        contentdetail.put("CONTENT", content);

        return contentdetail;
    }
    public int insert(String title, String content){
        HashMap<String, Object> insertboard = new HashMap<>();
        int pkId = boardList.size() + 1;
        insertboard.put("PK_ID", pkId);
        insertboard.put("TITLE", title);
        insertboard.put("CONTENT", content);

        boardList.add(insertboard);
        return pkId;
    }

    public HashMap<Boolean,Boolean> delete(String pkId){
        HashMap<Boolean, Boolean> boarddelete = new HashMap<>();
        boarddelete.put(true, true); 
        return boarddelete;
    }
    
    public HashMap<String,Object> mixed(Integer pageNumber, String pkId, String title, String content){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list",this.list(pageNumber));
        resultMap.put("view",this.view(pkId));
        resultMap.put("insert",this.insert(title,content));
        resultMap.put("delete",this.delete(pkId));
        return resultMap;
    }


}
