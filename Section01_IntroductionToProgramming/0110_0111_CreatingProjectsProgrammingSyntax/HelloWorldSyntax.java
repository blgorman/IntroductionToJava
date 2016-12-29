/**
 * JavaDocs above classes describe the class
 * and the description has to end with a period.
 * @author [authornamehere]
 */
public class HelloWorldSyntax 
{
    /*
         Comment Block starts with /* and ends with * / (no space)
         all lines inside are comments
         
    */
    
    //a single comment line 
	//starts with two forward slashes 
    //the next line is not a comment without //
   
    /*keywords: reserved by Java, highlighted in blue in Netbeans (other colors
                in other IDEs
                
                public ==> anyone can see it/use it
                private ==> only certain parts of code can see it/use it
                class ==> an object which can be instantiated (created)
                new  ==> the word used to instantiate an object
                static ==> available without instantiation
    */
    
    /*parts of code syntax:
     *          { ==> left curly brace -- opens a code block
     *          } ==> right curly brace -- closes a code block
     *          " ==> quote -- starts and ends String literals (variables)
     *          [ ==> left bracket -- opens an array and contains size indicator
     *          ] ==> right bracket -- closes an array
     *          ; ==> semi-colon -- ends a directive
     */
    
    public void main(String[] args)
    {
        System.out.println("Hello World "
                            + "Syntax Lesson!");
        
    }
}


