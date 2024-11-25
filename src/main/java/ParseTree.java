public class ParseTree {
    Node root;

    public ParseTree() {
        this.root = new Node("PROGRAM");
        Node HEADER = addLeaf(root, "HEADER");
        Node DECLARATIONS = addLeaf(root, "DECLARATIONS");
        Node BLOCK = addLeaf(root, "BLOCK");
        Node period = addLeaf(root, ".");

        Node program = addLeaf(HEADER, "program");
        Node id = addLeaf(HEADER, "id");
        Node semicolon = addLeaf(HEADER, ";");

        Node VariableDeclarationSection = addLeaf(DECLARATIONS, "VARIABLEDECLARATIONSECTION");
        Node ProcedureDeclarations = addLeaf(DECLARATIONS, "PROCEDUREDECLARATIONS");

        Node var = addLeaf(VariableDeclarationSection, "var");
        Node VariableDeclarations = addLeaf(VariableDeclarationSection, "VARIABLEDECLARATIONS");

        Node VariableDeclaration = addLeaf(VariableDeclarations, "VARIABLEDECLARATION");
        Node VariableDeclarationsPrime = addLeaf(VariableDeclarations, "VARIABLEDECLARATIONS'");

        Node VariableDeclaration2 = addLeaf(VariableDeclarationsPrime, "VARIABLEDECLARATION");
        Node VariableDeclarationsPrime2 = addLeaf(VariableDeclarationsPrime, "VARIABLEDECLARATION'");

        Node IdentifierList = addLeaf(VariableDeclaration, "IDENTIFIERLIST");
        Node colon = addLeaf(VariableDeclaration, ":");
        Node Type = addLeaf(VariableDeclaration, "TYPE");
        Node semicolon2 = addLeaf(VariableDeclaration, ";");

        Node id2 = addLeaf(IdentifierList, "id");
        Node IdentifierListPrime = addLeaf(IdentifierList, "IDENTIFIERLIST'");

        Node comma = addLeaf(IdentifierListPrime, ",");
        Node id3 = addLeaf(IdentifierListPrime, "id");
        Node IdentifierListPrime2 = addLeaf(IdentifierListPrime, "IDENTIFIERLIST'");

        Node integer = addLeaf(Type, "integer | real");

        Node ProcedureHeader = addLeaf(ProcedureDeclarations, "PROCEDUREHEADER");
        Node Declarations2 = addLeaf(ProcedureDeclarations, "DECLARATIONS");
        Node Block2 = addLeaf(ProcedureDeclarations, "BLOCK");
        Node semicolon3 = addLeaf(ProcedureDeclarations, ";");
        Node ProcedureDeclarations2 = addLeaf(ProcedureDeclarations, "PROCEDUREDECLARATIONS");

        Node procedure = addLeaf(ProcedureHeader, "procedure");
        Node id4 = addLeaf(ProcedureHeader, "id");
        Node semicolon4 = addLeaf(ProcedureHeader, ";");
        Node Block3 = addLeaf(ProcedureHeader, "Block");

        Node begin = addLeaf(BLOCK, "begin");
        Node Statements = addLeaf(BLOCK, "STATEMENTS");
        Node end = addLeaf(BLOCK, "end");

        Node Statement = addLeaf(Statements, "STATEMENT");
        Node StatementsPrime = addLeaf(Statements, "STATEMENTS'");

        Node semicolon5 = addLeaf(StatementsPrime, ";");
        Node Statement2 = addLeaf(StatementsPrime, "STATEMENT");
        Node StatementsPrime2 = addLeaf(StatementsPrime, "STATEMENTS'");

        Node id5 = addLeaf(Statement2, "id");
        Node assign = addLeaf(Statement2, ":=");
        Node Expression = addLeaf(Statement2, "EXPRESSION");

        Node SimpleExpression = addLeaf(Expression, "SIMPLEEXPRESSION");
        Node ExpressionPrime = addLeaf(Expression, "EXPRESSION");

        Node relop = addLeaf(ExpressionPrime, "relop");
        Node SimpleExpression2 = addLeaf(ExpressionPrime, "SIMPLEXPRESSION");

        Node Term = addLeaf(SimpleExpression, "TERM");
        Node SimpleExpressionPrime = addLeaf(SimpleExpression, "SIMPLEEXPRESSION'");

        Node addop = addLeaf(SimpleExpressionPrime, "addop");
        Node Term2 = addLeaf(SimpleExpressionPrime, "TERM");
        Node SimpleExpressionPrime2 = addLeaf(SimpleExpressionPrime, "SIMPLEEXPRESSION'");

        Node Factor = addLeaf(Term, "FACTOR");
        Node TermPrime = addLeaf(Term, "TERM'");
        Node mulop = addLeaf(TermPrime, "mulop");
        Node Factor2 = addLeaf(TermPrime, "FACTOR");
        Node TermPrime2 = addLeaf(TermPrime, "TERM'");

        Node ExpressionPrime2 = addLeaf(Factor, "id | num | ( EXPRESSION ) | not Factor");

    }

    public Node addLeaf(Node parent, String val) {
        Node leaf = new Node(val);
        parent.children.add(leaf);

        return leaf;
    }

    public void printTree() {
        preorderTraversal(this.root);
    }

    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);

        for (Node child : node.children) {
            preorderTraversal(child);
        }
    }

}
