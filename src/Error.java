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
    public static void VARIABLE_NAME_RESERVED(String v){
        throw new RuntimeException("Variable name '"+v+"' is reserved");
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

    /*Loop errors*/
    public static void INCORRECT_LOOP_CONDITION(String node){
        throw new RuntimeException("Condition for loops must be a boolean value: '"+node+"'");
    }

    /*Array errors*/
    public static void ARRAY_INDEX_VAR_NOT_INT(String node){
        throw new RuntimeException("Variable used for array index must be an integer: '"+node+"'");
    }
    public static void ARRAY_INDEX_NOT_VALID(String node){
        throw new RuntimeException("Array index is not : '"+node+"'");
    }
    public static void ARRAY_INDEX_OUT_OF_BOUNDS(String node){
        throw new RuntimeException("Array index out of bounds: '"+node+"'");
    }

    /*Assignment value errors*/
    public static void ASSIGNMENT_VALUE_NOT_VALID(String node){
        throw new RuntimeException("Assignment value not valid: '"+node+"'");
    }
    public static void CAN_NOT_ASSIGN_TO(String node){
        throw new RuntimeException("You can not assign values to " + node);
    }

    /*If errors*/
    public static void INCORRECT_IF_CONDITION(String node){
        throw new RuntimeException("Condition for if statement must be a boolean value: '"+node+"'");
    }

    /*Out errors*/
    public static void OUT_TOO_MANY_ARGS(){
        throw new RuntimeException("Out statement can only take one argument");
    }

    /*Function call errors*/
    public static void FUNCTION_CALL_WRONG_AMOUNT_OF_ARGS(String node){
        throw new RuntimeException("Function call has wrong amount of arguments: " + node);
    }

    /*Unary op errors*/
    public static void TYPE_NOT_VALID_FOR_UNARY_PLUS(String node){
        throw new RuntimeException("Type not valid for unary plus operation: " + node + " (must be integer or float)");
    }
    public static void TYPE_NOT_VALID_FOR_UNARY_MINUS(String node){
        throw new RuntimeException("Type not valid for unary minus operation: " + node + " (must be integer or float)");
    }
    public static void TYPE_NOT_VALID_FOR_UNARY_NOT(String node){
        throw new RuntimeException("Type not valid for unary not operation: " + node+" (must be boolean)");
    }

    /*Binary op errors*/
    public static void TYPE_NOT_VALID_FOR_BINARY_PLUS(String node){
        throw new RuntimeException("Type not valid for binary plus operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_MINUS(String node){
        throw new RuntimeException("Type not valid for binary minus operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_MULT(String node){
        throw new RuntimeException("Type not valid for binary multiplication operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_DIV(String node){
        throw new RuntimeException("Type not valid for binary division operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_AND(String node){
        throw new RuntimeException("Type not valid for binary and operation: " + node + " (must be booleans)");
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_OR(String node){
        throw new RuntimeException("Type not valid for binary or operation: " + node + " (must be booleans)");
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_EQ(String node){
        throw new RuntimeException("Type not valid for binary equals operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_NEQ(String node){
        throw new RuntimeException("Type not valid for binary not equals operation: " + node + " (must be integer, float or boolean)");
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_GT(String node){
        throw new RuntimeException("Type not valid for binary greater than operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_GTE(String node){
        throw new RuntimeException("Type not valid for binary greater than or equals operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_LT(String node){
        throw new RuntimeException("Type not valid for binary less than operation: " + node);
    }
    public static void TYPE_NOT_VALID_FOR_BINARY_LTE(String node){
        throw new RuntimeException("Type not valid for binary less than or equals operation: " + node);
    }
}
