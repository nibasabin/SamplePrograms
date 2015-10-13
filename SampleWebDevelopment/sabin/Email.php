<?php
require'connect.php';
if($_POST)
{
$to = $_POST['To'];
$subject = $_POST['Subject'];
$Message = $_POST['Message'];

mail($to,$subject,$Message);
}
?>



<html>
    <title> Email</title>
    <style>
        #container
        {
            height:400px;
            width:900px;
            border-style:solid;
            border-width:2px;
            background-color:#666666;
            margin:auto;
        }
        #box1
        {
            height:125px;
            width:900px;
            
            background-color:#000000;
        }
         #box2
        {
            height:275px;
            width:900px;
        
            background-color:#ff3300;
        }
        #box1c
        {
            height:125px;
            width:275px;
            background-color:#cccccc;
            float:left  
        }
        #box1b
        {
            height:125px;
            width:500px;
            background-color:#cccccc;
            float:left;
        }
         #box1a
        {
            height:125px;
            width:125px;
            background-color:#cccccc;
            float:left;
            
        }
      
    </style>
 <head >
    <div style="height:200px">
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        
    </div>
    </head>
    <body style='background-color:#cccccc'><br><br>
    <div id='container'>
 
        <form type='submit' method='post'action="MessageSent.php">
            <div id='box1'>
                <div id='box1a'>   
                    <br>
                    <label style='font-size:20px;margin:20px;'>Send to :</label><br><br>
                    <label style='font-size:20px;margin:20px;'>Subject :</label><br><br>
                    <label style='font-size:15px;margin:10px;'>Your Message</label>
                </div>
                <div id='box1b'><br>
                    <input style="padding:10px;height:20px;width:350px"  type='text'name='To' ><br><br>
                    <input style="padding:10px;height:20px;width:350px" type='text' name='Subject'><br>  </div> 
                <div id='box1c'><br>
                    <center>  <input type='submit'value='Send' style='height:75px;width:175px;background-color:#0000FF;color:white;font-size:30px'></center>
                </div>
                <div
            </div>
        
            <div id='box2'>
             
             <textarea name='Message' style="width:900px;height:275px"></textarea>
            </div>
    </div>
        
      
       
    </body>
</html>
