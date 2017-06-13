var fs = require('fs');

fs.readdir(".", function(err, items) {
    items.forEach(function(file){
        if (file.indexOf(".mp3.wav")+1) {
            fs.rename(file, file.substring(file.indexOf("_")+1, file.indexOf(".")).concat(".wav"));
        }
    });
});