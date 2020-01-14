# Questions

## Bug Report!

Q: What is an excellent bug report you created at a previous company which was of a high priority, high severity in a build about to be deployed to production? (Please write the bug report below)


A: Unfortunately I can't remember if I ever had a bug that would be both High priority and severity in a build about to be deployed to prod.
But as an example this is what it would look like. 
####Title: Clicking 'Log in' button throws Internal Server error
#####Description: After filling out username and password field and clicking Log In button it throws "Internal Server error".
Steps:  
1. Go to splice.com  
2. Click 'Log in' Button  
3. Fill out Username and Password field with valid credentials  
4. Click 'Log in' button  

Result: Internal Server Error  
Expected: Successful login  

Priority: High  
Severity: High  
Attach screenshots and logs  
Assign to developer and other people, i.e. PM

## Bug Report Follow up

Q: For the created bug report example you created in the previous question, what happened and how did you navigate the bug lifecycle, bug discussion? 

A: Besides logging a bug I would also try to let management know via chat or in person about this critical issue.  
After developers and management review the issue, most likely the deployment would be cancelled.  
A developer fixes the bug on his computer and most likely calls QA to verify it before committing the fix.  
If all is good, commits the fix and changes the status of the bug to "QA Ready".  
QA verifies the fix and does additional adhoc testing around the feature, i.e. trying invalid credentials, making sure valid profile page is loaded.  
QA sets the status of the bug to "Verified" and closes it.  
If all is good deploy to prod.
