

<html>
    <title>Search</title>
    
         <head >
    <div style="height:150px">
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        
    </div>
         <style>
         a
        {
            color:#ffffff;
            font-size:16px;
           text-decoration: none;
           margin-left:20px;
        }
             #container{
                 height:300px;
                 width:906px;
                 background-color:#000000;
                 margin:auto;
                 
             }
             #box1
             {
                 height:55px;
                 width:906px;
                 background-color:#006666;
                 
             }
             #box1a
             {
                 height:55px;
                 width:706px;
                 float:left;
                 background-color:#006666;
             }
              #box1b
             {
                 height:55px;
                 width:200px;
                 float:right;
                 background-color:#006666;
             }
              #box2
             {
                 height:250px;
                 width:906px;
                 background-color:#666666;
                 overflow:scroll;
                 
             }
                 a:hover
     {
         color:#0000FF;
     }
         
         </style>
         <body style="background-color:#cccccc"><br><br>
             <div id="container">
                
                 <div id="box1">
                     <div id="box1a"><br>
                     <form method="post">
                     <input style="margin-left:20px;width:150px" type="text" name="Search" placeholder="Search Items..">
                     <input type="submit" value='Search' style="height:50px; width:100px">
                     </form>
                     </div>
                     <div id="box1b">
                          <?php
                          session_start();
                            $User= $_SESSION['user'];
                            $Pass=$_SESSION['pass'];
                     if(($User=='Admin')&&($Pass=='Admin123'))
                     {
                         $site="AdminPage.php";
                     }
                     else
                     {
                         $site="UserPage.php";
                     }
                     ?>
                        <center> <a href=<?php echo $site;?>><input style="height:40px;width:150px;margin-top:10px;color:white;background-color:#0000FF" type="submit" value='Back'></a>    </center>
                         
                         
                        
                     
                     </form> 
                     </div>
                     
                  
                 </div>
                 <div id="box2">
                    
                     <label style="color:white">  
                     <?php
require'connect.php';
//session_start();
$name='';
$name1='';
 
if($_POST)
{
    echo"<label style='margin-left:20px;color:yellow;font-size:25px'>Sell Items</label><br><br>";
$searchq=$_POST['Search'];
$find=mysql_query("SELECT * FROM SellItem WHERE ItemName LIKE '%$searchq%'");
while($row=mysql_fetch_assoc($find))
{   
   //$ItemName=$row['ItemName'];
   $ItemId=$row['ItemId'];
   //echo" what is happening".$ItemName;
    $name="<a  href= SearchResult.php?id=$ItemId>" .$row['ItemName'] . "</a>"; 
    echo $name."<br>";
   
   // $_SESSION['result']=$row['ItemName'];
}
 echo"<hr><br>";
 echo"<label style='margin-left:20px;color:yellow;font-size:25px'>Trade Items</label><br><br>";
$find2=mysql_query("SELECT * FROM TradeItem WHERE ItemName LIKE '%$searchq%'");
while($row2=mysql_fetch_assoc($find2))
{
    $TradeId=$row2['TradeId'];
    $name1="<a href = SearchResult.php?id=$TradeId>" .$row2['ItemName'] . "</a>"; 
    echo $name1."<br>";
   // $_SESSION['result']=$row2['ItemName'];
}
}

?></label>
                     
                 </div>
               
             </div>
    </body>
</html>