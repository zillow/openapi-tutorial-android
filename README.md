### Zillow OpenAPI Tutorial    
**Phase 1 - Manual Code Creation:**  
SEE [master branch](https://github.com/zillow/openapi-tutorial-android/tree/master)  
```  
1. Create a basic android project with data/domain/presentation layers.  We will focus on the data layer here.  
2. Create network models off of the YAMLs in the contracts repo  
3. Create mappers between these network models and our domain models  
4. Create api interfaces that tell Retrofit how to communicate with our webservices  
5. Create a Retrofit client in our repository class, which implements our api interface definitions  
DONE  
```  
      
**Phase 2 - Code Generation:**  
SEE [codegen branch](https://github.com/zillow/openapi-tutorial-android/tree/codegen)  
```  
1. Create a basic android project with data/domain/presentation layers.  We will focus on the data layer here.  
2. Copy codegen jar from contracts repo  --  SEE [contracts repo codegen branch](https://github.com/zillow/openapi-tutorial-contracts/tree/codegen)    
3. Create mappers between these network models and our domain models  
DONE  
```  
  
**Phase 3 - Reusable Objects + Code Generation:**  
SEE [sharedcode branch](https://github.com/zillow/openapi-tutorial-android/tree/sharedcode)  
```  
1. Create a basic android project with data/domain/presentation layers.  We will focus on the data layer here.  
2. Copy codegen jar from contracts repo  --  SEE [contracts repo sharedcode branch](https://github.com/zillow/openapi-tutorial-contracts/tree/sharedcode)    
3. Create mappers between these network models and our domain models    
DONE  
```  