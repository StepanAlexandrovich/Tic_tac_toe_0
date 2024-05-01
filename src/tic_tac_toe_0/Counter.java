package tic_tac_toe_0;

public class Counter {
    int index;
    Result result;
    Counter(Result result){ this.result = result; }
    
    public int process(String[] array){
        recursion("0",array,-1);
        
        return index;
    }
    
    public int recursion(String symbol,String[] arrayOut,int coordinate){
        String[] array = arrayOut.clone();
        if(coordinate>=0){ array[coordinate] = symbol; }
        if(result.process(array)==symbol){ return 2; }
        
        //print(array);
        
        int score = 0,maxScore = -1,index = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]==null){
                if(symbol=="X"){ score = recursion("0",array,i); }
                if(symbol=="0"){ score = recursion("X",array,i); }
                if(score>maxScore){ maxScore = score; index = i;}
            }
            
        }
        
        this.index = index;
        
        if(maxScore==-1){ return 1; }
        else{ return 2 - maxScore;  }
    }
    
    public void print(String[] array){
        int i = 0;
        for(int x = 0;x<2;x++){
            for(int y = 0;y<2;y++){
                if(array[i]==null){ System.out.print("_ "); }else{
                    System.out.print(array[i]+" ");
                }
                i++;
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
