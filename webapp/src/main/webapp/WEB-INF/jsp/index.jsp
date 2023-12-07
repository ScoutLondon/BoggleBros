<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boggle Bros- Become A Rat Parent</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Oswald&display=swap" rel="stylesheet">
<script src="/script/script.js" defer></script>
<style>
    body{
        font-family: 'Montserrat', sans-serif;
    }
</style>
</head>
<body>
    <header>
            <img src="https://i0.wp.com/bogglebros.com/wp-content/uploads/2022/06/294849392_1126915941577557_873610920801494896_n.png?w=1343&ssl=1"
            alt="Boggle Bros Rattery NC">
        <p class="bbr-slogan">Become a rat parent.</p>
    </header>

    <nav class="navbar">
        <ul>
            <li><a href="/pages/home.html">Home</a></li>
            <li><a href="/pages/login.html">Login</a></li>
            <li><a href="/pages/register.html">Register</a></li>

        </ul>
    </nav>

    <section class="table" style="margin-left: 5rem;">
        <h2>Available Rats</h2>
        <table>
            <tr>
              <th>Rat Name</th>
              <th>Sex</th>
              <th>Birthday</th>
              <th>Available</th>
              <th>Mother</th>
              <th>Father</th>
              <th>Genes</th>
            </tr>
            <tr>
              <td>Butters</td>
              <td>Male</td>
              <td>11/21/23</td>
              <td>1/20/24</td>
              <td>Fanta</td>
              <td>Kuzco</td>
              <td>Black Self Silvermane</td>
            </tr>
            <tr>
                <td>Pacha</td>
                <td>Male</td>
                <td>11/21/23</td>
                <td>1/20/24</td>
                <td>Fanta</td>
                <td>Kuzco</td>
                <td>Harley Dwarf</td>
              </tr>
              <tr>
                <td>Maude</td>
                <td>Female</td>
                <td>11/21/23</td>
                <td>1/20/24</td>
                <td>Fanta</td>
                <td>Kuzco</td>
                <td>Werewolf Dwarf</td>
              </tr>
              <tr>
                <td>Walter</td>
                <td>Male</td>
                <td>11/21/23</td>
                <td>1/20/24</td>
                <td>Fanta</td>
                <td>Kuzco</td>
                <td>Blue Rex</td>
              </tr>
              <tr>
                <td>Mochi</td>
                <td>Female</td>
                <td>11/21/23</td>
                <td>1/20/24</td>
                <td>Fanta</td>
                <td>Kuzco</td>
                <td>Siamese</td>
              </tr>
              <tr>
                <td>Kronk</td>
                <td>Male</td>
                <td>11/21/23</td>
                <td>1/20/24</td>
                <td>Fanta</td>
                <td>Kuzco</td>
                <td>Siamese Dwarf</td>
              </tr>
          </table>
    </section>

    <br>

    <div class="ratselect" style="margin-left: 5rem;">
        <h3>Which rat are you most interested in?</h3>
        <form action="/pages/register.html">
        <label for="rats">Choose a rat:</label>
        <select name="rats" id="rats">
        <option value="butters">Butters</option>
        <option value="pacha">Pacha</option>
        <option value="maude">Maude</option>
        <option value="walter">Walter</option>
        <option value="mochi">Mochi</option>
        <option value="kronk">Kronk</option>
        </select>
        <br>
        <input type="submit" value="Submit">
        </form>
    </div>

    <br>

    <div class="ratgif" style="margin-left: 5rem;">
        <img src="https://media.tenor.com/mGRwRjckqEEAAAAd/rat.gif" alt="Rotating Rat">
    </div>

    <br>

    <div class="genetics" style="margin-left: 5rem;">
        <h3>What genetics are you looking for?</h3>

    <label for="geneInput">Preferred Genes:</label>
    <input type="text" id="geneInput">
    <button onclick="addGene()">Add Gene</button>

    <h3>Genetic Wishlist:</h3>
    <ul id="geneList"></ul>
    </div>

    <br>

    <div class="video">
        <h3 style="margin-left: 5rem;">Check out one of our dwarf rats!</h3>
        <iframe width="560" height="315" style="margin-left: 5rem;" src="https://www.youtube.com/embed/7KWPHCXycqE?si=k9gcMVRNMY1-hsWk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    </div>
</body>
</html>