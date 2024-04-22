public class Error {
    public static void SYNTAX_ERROR(NullPointerException e){
        throw new RuntimeException("Syntax error: "+e);
    }
    public static void VARIABLE_ALREADY_DECLARED(String v){
        throw new RuntimeException("Variable '"+v+"' has already been declared");
    }
    public static void VARIABLE_NOT_DECLARED(String v) {
        throw new RuntimeException("Variable '" + v + "' has not been declared");
    }
    public static void FUNCTION_ALREADY_DECLARED(String v){
        throw new RuntimeException("Function '"+v+"' has already been declared");
    }
    public static void FUNCTION_NOT_DECLARED(String v){
        throw new RuntimeException("Function '"+v+"' has not been declared");
    }
    public static void FUNCTION_NAME_RESERVED(String v){
        throw new RuntimeException("Function name '"+v+"' is reserved");
    }
    public static void INCORRECT_END_FUNCTION(){
        throw new RuntimeException("Incorrect end function");
    }
    public static void FUNC_PARAM_EQ_FUNC_NAME(){
        throw new RuntimeException("Parameter for function can not be the same as name for function");
    }
    public static void GLOBAL_MUST_CONTAIN_STMT(String node){
        throw new RuntimeException("Global must contain statement, not '"+node+"'");
    }
    public static void INCORRECT_TYPE_FOR_VALUE_EXP(){
        throw new RuntimeException("Incorrect type for value expression");
    }
    public static void DECLARE_ASSIGNMENT_WRONG_TYPE(String node) {
        throw new RuntimeException("Declare assignment wrong type, not '"+node+"'");
    }

    /*CTRL flow errors*/
    public static void CONTINUE_BREAK_NOT_ALLOWED_IN_GLOBAL(String node){
        throw new RuntimeException("Control statement not allowed in global: '"+node+"'");
    }
    public static void CONTINUE_BREAK_NOT_ALLOWED_IN_FUNCTION(String node){
        throw new RuntimeException("Control statement not allowed in function: '"+node+"'");
    }
}
