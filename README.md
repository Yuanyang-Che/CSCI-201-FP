### UserInfo 
Get all user
> $ curl localhost:8080/user/all
  
To create new user, provide email, userName and password
> $ curl localhost:8080/user/add -d email=___ -d userName=___ -d pw=___

To update existing user, provide the email, and the updated userName and password
> $ curl localhost:8080/user/update -d email=__ -d name=__ -d pw=__

To search for an user, provide the email
> $ curl localhost:8080/user/search -d email=___

### Dietary Restriction
Get all user's dietary restriction
> $ curl localhost:8080/diet/all
  
To create dietary restriction for existing user, provide user's email, diet, exIngred, intolerance
> $ curl localhost:8080/diet/add -d email=___ -d diet=___ -d exIngred=___ -d intolerance=___

To update existing user's dietary restriction, provide user's email, diet, exIngred, intolerance
> $ curl localhost:8080/diet/update -d email=___ -d diet=___ -d exIngred=___ -d intolerance=___

To search user's dietary restriction, provide email
> $ curl localhost:8080/diet/search -d email

### Last Recipe
Get all users' last recipe query
> $ curl localhost:8080/last/all
  
To create some user's last query, provide email and the last query
> $ curl localhost:8080/last/add -d email=__ -d lastQuery=__

To update existing one, provide the email, and the updated userName and password
> $ curl localhost:8080/last/update -d email=__ -d lastQuery=__

To search user's last query, provide email
> $ curl localhost:8080/last/search -d email=___