/* 
 * @copyright (c) 2008, Hedspi, Hanoi University of Technology
 * @author Huu-Duc Nguyen
 * @version 1.0
 */

#include <stdlib.h>
#include <string.h>
#include "semantics.h"
#include "error.h"

extern SymTab* symtab;
extern Token* currentToken;

Object* lookupObject(char *name) {
  // TODO
	Object* tmp = NULL;
  Scope* currentScope = symtab->currentScope;

  while(currentScope != NULL) 
  {
    tmp = findObject(currentScope->objList,name);
    if (tmp == NULL)
    {
      currentScope = currentScope->outer;
    }
    else return tmp;
  }

  tmp = findObject(symtab->globalObjectList,name);
  return tmp;
}

void checkFreshIdent(char *name) {
  // TODO
	Object* tmp = findObject(symtab->currentScope->objList,name);
	if(tmp != NULL)
		error(ERR_DUPLICATE_IDENT, currentToken->lineNo, currentToken->colNo);
}

Object* checkDeclaredIdent(char* name) {
  // TODO
	Object* tmp =  lookupObject(name);
	if(tmp == NULL)
		error(ERR_UNDECLARED_IDENT, currentToken->lineNo, currentToken->colNo);
	return tmp;
}

Object* checkDeclaredConstant(char* name) {
  // TODO
	Object* tmp = checkDeclaredIdent(name);

	if(tmp -> kind != OBJ_CONSTANT)
		error(ERR_UNDECLARED_CONSTANT, currentToken->lineNo, currentToken->colNo);
	return tmp;
}

Object* checkDeclaredType(char* name) {
  // TODO
	Object* tmp = checkDeclaredIdent(name);

	if(tmp -> kind != OBJ_TYPE)
		error(ERR_UNDECLARED_TYPE, currentToken->lineNo, currentToken->colNo);
	return tmp; 
}

Object* checkDeclaredVariable(char* name) {
  // TODO
	Object* tmp = checkDeclaredIdent(name);

	if(tmp -> kind != OBJ_VARIABLE)
		error(ERR_UNDECLARED_VARIABLE, currentToken->lineNo, currentToken->colNo);
	return tmp;
}

Object* checkDeclaredFunction(char* name) {
  // TODO
	Object* tmp = checkDeclaredIdent(name);

	if(tmp -> kind != OBJ_FUNCTION)
		error(ERR_UNDECLARED_FUNCTION, currentToken->lineNo, currentToken->colNo);
	return tmp;
}

Object* checkDeclaredProcedure(char* name) {
  // TODO
	Object* tmp = checkDeclaredIdent(name);

	if(tmp -> kind != OBJ_PROCEDURE)
		error(ERR_UNDECLARED_PROCEDURE, currentToken->lineNo, currentToken->colNo);
	return tmp;
}

Object* checkDeclaredLValueIdent(char* name) {
  // TODO
	Object* tmp = checkDeclaredIdent(name);
	switch(tmp->kind)
	{
		case OBJ_VARIABLE:
		case OBJ_FUNCTION:
		case OBJ_PARAMETER:
			return tmp;
		default:
			error(ERR_INVALID_LVALUE, currentToken->lineNo, currentToken->colNo);
	}
	return tmp;
}