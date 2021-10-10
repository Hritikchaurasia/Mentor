## PORT 
- user-service : 8000
- eureka-server : 8761
- video-service : 8001
- api-gateway : 5000

## Api-Gateway
|  | endpoints |  request-type | body | Header |
| ------ | ------ | ------ | ----- | ----- |
| sign-up | localhost:8000/user/signup  | Post | email, password, firstName, firstName(optional) | |
| login | localhost:8000/user/login  | Post | email, password | |
| get all videos | localhost:8001/videos/  | Get | | |
| stream video| localhost:8001/videos/{video-url} ( produces = "videos/mp4" ) | Post | |Range |


## user service
|  | endpoints |  request-type | body |
| ------ | ------ | ------ | ---- |
| sign-up | localhost:8000/user/signup  | Post | email, password, firstName, firstName(optional) |
| login | localhost:8000/user/login  | Post | email, password |



## video service
|  | endpoints |  request-type | Header |
| ------ | ------ | ------ | ---- |
| get all videos | localhost:8001/videos/  | Get | |
| stream video| localhost:8001/videos/{video-url} ( produces = "videos/mp4" ) | Post | Range |


