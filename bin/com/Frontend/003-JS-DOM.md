
## Mini-Tasks 003-JS-DOM

### Task 1: Color a `span/div` element content when a user moves the mouse over the element.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Background Color on Mouseover</title>
    <style>
        .highlight {
            background-color: yellow;
        }
    </style>
    <script>
        function highlightBackground(element) {
            element.classList.add('highlight');
        }

        function resetBackground(element) {
            element.classList.remove('highlight');
        }
    </script>
</head>
<body>
    <div onmouseover="highlightBackground(this)" onmouseout="resetBackground(this)">
        Hover over this div to see its background color change.
    </div>
</body>
</html>
```

### Task 2: Use prompt to read a value from user and display it in the span element.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Prompt Input Display</title>
    <script>
        function displayInput() {
            var userInput = prompt("Enter a value:");
            if (userInput !== null) {
                document.getElementById('output').textContent = userInput;
            }
        }
    </script>
</head>
<body>
    <span id="output"></span>
    <button onclick="displayInput()">Enter Value</button>
</body>
</html>
```

### Task 3: Display the mouse X and Y coordinates in a `<span>` tag when clicking on a `<h1>` tag containing a paragraph.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mouse Coordinates</title>
    <script>
        function showCoordinates(event) {
            var x = event.clientX;
            var y = event.clientY;
            document.getElementById('coordinates').textContent = 'X: ' + x + ', Y: ' + y;
        }
    </script>
</head>
<body>
    <h1 onclick="showCoordinates(event)">Click here to show mouse coordinates</h1>
    <p>Move your mouse after clicking the header to see coordinates.</p>
    <span id="coordinates"></span>
</body>
</html>
```

### Task 4: JavaScript code for character counts in a `textarea`.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Character Count</title>
    <script>
        function countCharacters() {
            var text = document.getElementById('inputText').value;
            var count = text.length;
            document.getElementById('charCount').textContent = 'Character count: ' + count;
        }
    </script>
</head>
<body>
    <textarea id="inputText" oninput="countCharacters()"></textarea>
    <div id="charCount">Character count: 0</div>
</body>
</html>
```
