var connect = require("connect");
var app = connect();

var listFB = function(req, res, next) {
  var MongoClient = require("mongodb").MongoClient;
  var url = "mongodb://localhost:27017/";

  MongoClient.connect(url, function(err, db) {
      if (err) throw err;

      var dbo = db.db("cataloger");
      dbo.collection("fb").find({}).toArray(function(err, result) {
          if (err) throw err;
          res.end(JSON.stringify(result));
          db.close();
        });
    }
  );
};

var listReddit = function(req, res, next) {
    var MongoClient = require("mongodb").MongoClient;
    var url = "mongodb://localhost:27017/";
  
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
  
        var dbo = db.db("cataloger");
        dbo.collection("reddit").find({}).toArray(function(err, result) {
            if (err) throw err;
            res.end(JSON.stringify(result));
            db.close();
          });
      }
    );
  };

app.use("/fb", listFB);
app.use("/reddit", listReddit);
app.listen(3000);

console.log("http://localhost:3000/fb");
console.log("http://localhost:3000/reddit");