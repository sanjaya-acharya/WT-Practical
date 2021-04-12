<?php
    echo readfile("filename.txt");

    $file = fopen("filename.txt", "rw") or die("sorry,we are Unable to open file!");
    echo fread($file,filesize("filename.txt"));

$text = "abc";
fwrite($file, $text);
$text = "TEXT";
fwrite($file, $text);
fclose($file);
?>


<html>
<body>

<form action="" method="post" enctype="multipart/form-data">
  Select image:
  <input type="file" name="image" id="image">
  <input type="submit" value="Upload Image" name="submit">
</form>

</body>
</html