var http = require("http");

var MongoClient = require("mongodb").MongoClient;
var url = "mongodb://localhost:27017/";

http.createServer(function(req, res) {
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        
        var dbo = db.db("cataloger");
        dbo.collection("fb").findOne({}, function(err, result) {
            if (err) throw err;
            res.end(result.post_message);
            db.close();
        });
    });

}).listen(3000);

console.log("Server running at http://localhost:3000/");