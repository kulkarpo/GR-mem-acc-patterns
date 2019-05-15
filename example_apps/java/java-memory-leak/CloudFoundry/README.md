Memory Leak Application
==============

This project contains a Cloud Foundry application, with a terrible memory leak. The intent is to test the resilience of a Cloud Foundry environment, such as Bluemix.

## Running this application

1. Download this project:

	git clone https://github.com/patrocinio/java-memory-leak

2. Push the application to your Cloud Foundry environment:

    cf push
    
3. Open the application log:

    cf logs application-name

4. Now the application will start leaking after you open the main web page. So in your browser, point to the application's URL  

5. Watch the log file showing the application allocating lots of memory and crashing

6. Stop the application

    cf stop application-name  




# Notice

© Copyright IBM Corporation 2014, 2016.

# License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

