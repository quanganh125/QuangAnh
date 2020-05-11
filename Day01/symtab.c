/* 
 * @copyright (c) 2008, Hedspi, Hanoi University of Technology
 * @author Huu-Duc Nguyen
 * @version 1.1
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "symtab.h"

void freeObject(Object* obj);
void freeScope(Scope* scope);
void freeObjectList(ObjectNode *objList);
void freeReferenceList(ObjectNode *objList);

SymTab* symtab;
Type* intType;
Type* charType;

/******************* Type utilities ******************************/

Type* makeIntType(void) {
  Type* type = (Type*) malloc(sizeof(Type));
  type->typeClass = TP_INT;
  return type;
}

Type* makeCharType(void) {
  Type* type = (Type*) malloc(sizeof(Type));
  type->typeClass = TP_CHAR;
  return type;
}

Type* makeArrayType(int arraySize, Type* elementType) {
  Type* type = (Type*) malloc(sizeof(Type));
  type->typeClass = TP_ARRAY;
  type->arraySize = arraySize;
  type->elementType = elementType;
  return type;
}

Type* duplicateType(Type* type) {
  // TODO
  Type* tmp = (Type*) malloc(sizeof(Type));
  tmp->typeClass = type->typeClass;
  if (tmp->typeClass == TP_ARRAY)
  {
    tmp->arraySize = type->arraySize;
    tmp->elementType = type->elementType;
  }
  return tmp;
}

int compareType(Type* type1, Type* type2) {  // return 0 if equal- 1 if not
  // TODO
  if(type1->typeClass != type2->typeClass)
    return 1;
  else
  {
    if(type1->typeClass == TP_ARRAY)
    {
      if (type1->arraySize != type2->arraySize || type1->elementType != type2->elementType)
        return 1;
      return compareType(type1->elementType,type2->elementType);
    }
    else return 0;
  }
}

void freeType(Type* type) {
  // TODO
  if(type->typeClass==TP_ARRAY && type->elementType!=NULL)
  {
    freeType(type->elementType);
  }
  free(type);
}

/******************* Constant utility ******************************/

ConstantValue* makeIntConstant(int i) {
  // TODO
  ConstantValue* tmp = (ConstantValue*)malloc(sizeof(ConstantValue));
  tmp->type = TP_INT;
  tmp->intValue = i;
  return tmp;
}

ConstantValue* makeCharConstant(char ch) {
  // TODO
  ConstantValue* tmp = (ConstantValue*)malloc(sizeof(ConstantValue));
  tmp->type = TP_CHAR;
  tmp->charValue = ch;
  return tmp;
}

ConstantValue* duplicateConstantValue(ConstantValue* v) {
  // TODO
  ConstantValue* tmp = (ConstantValue*)malloc(sizeof(ConstantValue));
  tmp->type = v->type;
  if(tmp->type == TP_INT)
    tmp->intValue = v->intValue;
  else tmp->charValue = v->charValue;
  return tmp;
}

/******************* Object utilities ******************************/

Scope* CreateScope(Object* owner, Scope* outer) {
  Scope* scope = (Scope*) malloc(sizeof(Scope));
  scope->objList = NULL;
  scope->owner = owner;
  scope->outer = outer;
  return scope;
}

Object* CreateProgramObject(char *programName) {
  Object* program = (Object*) malloc(sizeof(Object));
  strcpy(program->name, programName);
  program->kind = OBJ_PROGRAM;
  program->progAttrs = (ProgramAttributes*) malloc(sizeof(ProgramAttributes));
  program->progAttrs->scope = CreateScope(program,NULL);
  symtab->program = program;

  return program;
}

Object* CreateConstantObject(char *name) { 
  // TODO
  Object* tmp = (Object*) malloc(sizeof(Object));
  strcpy(tmp->name,name);
  tmp->kind = OBJ_CONSTANT;
  tmp->constAttrs = (ConstantAttributes*) malloc(sizeof(ConstantAttributes));
  tmp->constAttrs->value = NULL;
  return tmp;
}

Object* CreateTypeObject(char *name) {
  // TODO
  Object* tmp = (Object*) malloc(sizeof(Object));
  strcpy(tmp->name,name);
  tmp->kind = OBJ_TYPE;
  tmp->typeAttrs = (TypeAttributes*)malloc(sizeof(TypeAttributes));
  tmp->typeAttrs->actualType = NULL;
  return tmp;
}

Object* CreateVariableObject(char *name) {
  // TODO
  Object* tmp = (Object*) malloc(sizeof(Object));
  strcpy(tmp->name,name);
  tmp->kind = OBJ_VARIABLE;
  tmp->varAttrs = (VariableAttributes*)malloc(sizeof(VariableAttributes));
  tmp->varAttrs->type = NULL;
  tmp->varAttrs->scope = CreateScope(tmp,symtab->currentScope);
  return tmp;
}

Object* CreateFunctionObject(char *name) {
  // TODO
  Object* tmp = (Object*) malloc(sizeof(Object));
  strcpy(tmp->name,name);
  tmp->kind = OBJ_FUNCTION;
  tmp->funcAttrs = (FunctionAttributes*)malloc(sizeof(FunctionAttributes));
  tmp->funcAttrs->paramList = NULL;
  tmp->funcAttrs->returnType = NULL;
  tmp->funcAttrs->scope = CreateScope(tmp,symtab->currentScope);
  return tmp;
}

Object* CreateProcedureObject(char *name) {//-----------------------------------
  // TODO
  Object* tmp = (Object*) malloc(sizeof(Object));
  strcpy(tmp->name,name);
  tmp->kind = OBJ_PROCEDURE;
  tmp->procAttrs = (ProcedureAttributes*)malloc(sizeof(ProcedureAttributes));
  tmp->procAttrs->paramList = NULL;
  tmp->procAttrs->scope = CreateScope(tmp,symtab->currentScope);
  return tmp;
}

Object* CreateParameterObject(char *name, enum ParamKind kind, Object* owner) {
  // TODO
  Object* tmp = (Object*) malloc(sizeof(Object));
  strcpy(tmp->name,name);
  tmp->kind = OBJ_PARAMETER;
  tmp->paramAttrs = (ParameterAttributes*)malloc(sizeof(ParameterAttributes));
  tmp->paramAttrs->kind = kind;
  tmp->paramAttrs->type = NULL;
  tmp->paramAttrs->function = (Object*) malloc(sizeof(Object));
  tmp->paramAttrs->function = owner;
  return tmp;
}

void freeObject(Object* obj) {
  // TODO
  switch(obj->kind)
  {
    case OBJ_CONSTANT: free(obj->constAttrs); break;
    case OBJ_VARIABLE: free(obj->varAttrs); break;
    case OBJ_TYPE: free(obj->typeAttrs); break;
    case OBJ_FUNCTION: free(obj->funcAttrs);break;
    case OBJ_PROCEDURE: free(obj->procAttrs);break;
    case OBJ_PARAMETER: free(obj->paramAttrs);break;
    default: free(obj->progAttrs); break;
  }
  free(obj);
}

void freeScope(Scope* scope) {
  // TODO
  freeObjectList(scope->objList);
  free(scope);
}

void freeObjectList(ObjectNode *objList) {
  // TODO
  while (objList!=NULL)
  {
    ObjectNode* tmp=objList;
    objList = objList->next;
    freeObject(tmp->object);
    free(tmp);
  }
}

void freeReferenceList(ObjectNode *objList) {
  // TODO
  while (objList!=NULL)
  {
    ObjectNode* tmp=objList;
    objList = objList->next;
    freeObject(tmp->object);
    free(tmp);
  }
}

void AddObject(ObjectNode **objList, Object* obj) {
  ObjectNode* node = (ObjectNode*) malloc(sizeof(ObjectNode));
  node->object = obj;
  node->next = NULL;
  if ((*objList) == NULL) 
    *objList = node;
  else {
    ObjectNode *n = *objList;
    while (n->next != NULL) 
      n = n->next;
    n->next = node;
  }
}

Object* findObject(ObjectNode *objList, char *name) { 
  // TODO
  if(objList->object == NULL) return NULL;
  else if(objList->object->name == name) return objList->object;
  else return findObject(objList->next,name);
}

/******************* others ******************************/

void initSymTab(void) {
  Object* obj;
  Object* param;

  symtab = (SymTab*) malloc(sizeof(SymTab));
  symtab->globalObjectList = NULL;
  
  obj = CreateFunctionObject("READC");
  obj->funcAttrs->returnType = makeCharType();
  AddObject(&(symtab->globalObjectList), obj);

  obj = CreateFunctionObject("READI");
  obj->funcAttrs->returnType = makeIntType();
  AddObject(&(symtab->globalObjectList), obj);

  obj = CreateProcedureObject("WRITEI");
  param = CreateParameterObject("i", PARAM_VALUE, obj);
  param->paramAttrs->type = makeIntType();
  AddObject(&(obj->procAttrs->paramList),param);
  AddObject(&(symtab->globalObjectList), obj);

  obj = CreateProcedureObject("WRITEC");
  param = CreateParameterObject("ch", PARAM_VALUE, obj);
  param->paramAttrs->type = makeCharType();
  AddObject(&(obj->procAttrs->paramList),param);
  AddObject(&(symtab->globalObjectList), obj);

  obj = CreateProcedureObject("WRITELN");
  AddObject(&(symtab->globalObjectList), obj);

  intType = makeIntType();
  charType = makeCharType();
}

void cleanSymTab(void) {
  freeObject(symtab->program);
  freeObjectList(symtab->globalObjectList);
  free(symtab);
  freeType(intType);
  freeType(charType);
}

void enterBlock(Scope* scope) {
  symtab->currentScope = scope;
}

void exitBlock(void) {
  symtab->currentScope = symtab->currentScope->outer;
}

void declareObject(Object* obj) {
  if (obj->kind == OBJ_PARAMETER) {
    Object* owner = symtab->currentScope->owner;
    switch (owner->kind) {
    case OBJ_FUNCTION:
      AddObject(&(owner->funcAttrs->paramList), obj);
      break;
    case OBJ_PROCEDURE:
      AddObject(&(owner->procAttrs->paramList), obj);
      break;
    default:
      break;
    }
  }
 
  AddObject(&(symtab->currentScope->objList), obj);
}


