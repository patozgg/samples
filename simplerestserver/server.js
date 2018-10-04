var express = require('express');
var bodyParser = require('body-parser');
var methodOverride = require('method-override')

var app = express();

app.use(bodyParser.json());
app.use(methodOverride());


const basicAuth = require('express-basic-auth')
 
app.use(basicAuth({
    users: { 'demo': 'demo' }
}))


function checkForNull(variable) {
  if(variable == false || variable == 0) {
    return true;
  }
  else if(variable) {
    return true;
  }
  else {
    return false;
  }
}


app.get('/getAccount', function(req, res) {
 

   res.status(200).send('{"accountNumber":"12345678"}');
});
app.post('/bcsaSetStatus', function(req, res) {
   //Print the received JSON.
   console.log(req.body);

   //Print the status that was received...
   console.log(req.body.status);

   //... and store it into a variable.
   var status = req.body.status;

   //Create the response object.
   var responseObj = {};
   responseObj.status = status;
   responseObj.successFlag = true;

   //Send the response.
   res.status(200).send(JSON.stringify(responseObj));
});

app.post('/verify', function(req, res) {
	   //Print the received JSON.
	   console.log(req.body);

	   //Print the status that was received...
	   console.log(req.body.accountNumber);

	   //... and store it into a variable.
	   var accountNumber = req.body.accountNumber;

	   //Create the response object.
	   var responseObj = {};
	   responseObj.accountNumber = accountNumber;
	   responseObj.successFlag = true;
	   console.log(JSON.stringify(responseObj));
	   //Send the response.
	   res.status(200).send(JSON.stringify(responseObj));
	});




app.listen(1027);
console.log('Listening on port 1027...');
