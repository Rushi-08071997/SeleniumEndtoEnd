Feature: Application login
Scenario Outline: login through genuine user
Given initialize browser with chrome
And then navigate to the "https://qaclickacademy.com/"
And click on login link on homepage to land on login page
When user login through <Username> & <Password>
Then verify user is succesfully logged in or not
And close the browser

Examples:
|Username			    	        |Password |
|rushikeshbanarase@gmail.com|12345	  |
|sep@gmail.com              |123456   |

