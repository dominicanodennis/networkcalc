package com.example.dennis3;
import android.text.Editable;  
import android.text.Selection;  
import android.text.TextWatcher;  
import android.widget.EditText;  
  
/* 
 * ? 
 * */  
public class MaxLengthWatcher implements TextWatcher {  
  
    private int maxLen = 0;  
    private EditText editText = null;  
      
      
    public MaxLengthWatcher(int maxLen, EditText editText) {  
        this.maxLen = maxLen;  
        this.editText = editText;  
    }  
  
    public void afterTextChanged(Editable arg0) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,  
            int arg3) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {  
        // TODO Auto-generated method stub  
        Editable editable = editText.getText();  
        int len = editable.length();  
          
        if(len > maxLen)  
        {  
            int selEndIndex = Selection.getSelectionEnd(editable);  
            String str = editable.toString();  
            //  
            String newStr = str.substring(0,maxLen);  
            editText.setText(newStr);  
            editable = editText.getText();  
              
            //  
            int newLen = editable.length();  
            //  
            if(selEndIndex > newLen)  
            {  
                selEndIndex = editable.length();  
            }  
            //  
            Selection.setSelection(editable, selEndIndex);  
              
        }  
    }  
  
}  