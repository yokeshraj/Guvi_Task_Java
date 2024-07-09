
## Mini-Tasks 002-HTML-CSS

1. **Design the below equation using HTML & CSS**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Equation</title>
    <style>
        .equation {
            font-size: 2em;
            text-align: center;
        }
        .fraction {
            display: inline-block;
            text-align: center;
            vertical-align: middle;
        }
        .fraction span {
            display: block;
        }
        .top {
            border-bottom: 1px solid #000;
        }
    </style>
</head>
<body>
    <div class="equation">
        <span class="fraction">
            <span class="top">∂<sup>2</sup>u</span>
            <span>∂t<sup>2</sup></span>
        </span> = c<sup>2</sup>
        <span class="fraction">
            <span class="top">∂<sup>2</sup>u</span>
            <span>∂x<sup>2</sup></span>
        </span>
    </div>
</body>
</html>
```

2. **CSS rule of rounded rectangle, dashed border, grayscale for all image tags in your webpage**

```CSS
img {
    border: 2px dashed #000;
    border-radius: 15px;
    filter: grayscale(100%);
}
```

3. **Media rule to change only the font size of the web page when it's resized**

```CSS
@media screen and (max-width: 600px) {
    body {
        font-size: 14px;
    }
}
@media screen and (min-width: 601px) {
    body {
        font-size: 18px;
    }
}
```

4. **HTML & CSS to display different types of cursors**

```HTML
<html lang="en">
<head>
    <title>Cursors</title>
    <style>
        .default { cursor: default; }
        .pointer { cursor: pointer; }
        .crosshair { cursor: crosshair; }
        .move { cursor: move; }
        .text { cursor: text; }
    </style>
</head>
<body>
    <div class="default">Default Cursor</div>
    <div class="pointer">Pointer Cursor</div>
    <div class="crosshair">Crosshair Cursor</div>
    <div class="move">Move Cursor</div>
    <div class="text">Text Cursor</div>
</body>
</html>
```

5. **CSS class that meets the Box Model requirement for all div tags in your page**

```CSS
div {
    padding: 20px;
    margin: 10px;
    border: 2px solid #000;
}
```

6. **CSS class to change size of font, color font family when mouse moves over span tag in your webpage**

```CSS
span:hover {
    font-size: 20px;
    color: red;
    font-family: Arial, sans-serif;
}
```

7. **CSS 2D rule with `translate()` property to move an element**

```CSS
.move {
    transform: translate(50px, 100px);
}
```

8. **CSS class to show tooltip when mouse moved over the elements**

```HTML
<html lang="en">
<head>
    <title>Tooltip</title>
    <style>
        .tooltip {
            position: relative;
            display: inline-block;
        }
        .tooltip .tooltiptext {
            visibility: hidden;
            width: 120px;
            background-color: black;
            color: #fff;
            text-align: center;
            border-radius: 5px;
            padding: 5px;
            position: absolute;
            z-index: 1;
            bottom: 125%; /* Position above the element */
            left: 50%;
            margin-left: -60px;
            opacity: 0;
            transition: opacity 0.3s;
        }
        .tooltip:hover .tooltiptext {
            visibility: visible;
            opacity: 1;
        }
    </style>
</head>
<body>
    <div class="tooltip">Hover over me
        <div class="tooltiptext">Tooltip text</div>
    </div>
</body>
</html>
```

9. **Apply `clip property` with values of right & bottom and display the output**

```CSS
img {
    clip: rect(0px, 50px, 50px, 0px);
}
```

10. **Design the below image using HTML & CSS**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Letter Styling</title>
    <style>
        .styled-paragraph {
            font-size: 20px;
            line-height: 1.5;
        }
        .styled-paragraph::first-letter {
            font-size: 100px;
            float: left;
            line-height: 0.9;
            margin-right: 0.1em;
        }
        .styled-paragraph .indent {
            display: block;
        }
    </style>
</head>
<body>
    <p class="styled-paragraph">
        Drop caps can be used to <br>
      add emphasis to blocks <br>
      of texts but know they <br>
      can affect readability
    </p>
</body>
</html>
```

11. **Reshape a div, as shown in the example**

```HTML
<html lang="en">
<head>
    <title>Reshape Div</title>
    <style>
        .reshape {
            width: 250px;
            height: 150px;
            background-color: lightblue;
            border-top-left-radius: 25%;
            border-bottom-right-radius: 25%;
        }
    </style>
</head>
<body>
    <div class="reshape"></div>
</body>
</html>

```

12. **Set a background image to be centered and not repeat**

```CSS
body {
    background-image: url('background.jpg');
    background-position: center;
    background-repeat: no-repeat;
}
```

13. **CSS rules to set the direction of flexible items inside the `<div></div>` element in reverse order**

```CSS
div {
    display: flex;
    flex-direction: row-reverse;
}
```

14. **Give the `<div>` element an image border using the image "border.png". Slice the image at 30px and stretch it**

```CSS
div {
    border-image: url('border.png') 30 stretch;
    border-width: 30px;
}
```

15. **Give the `<div>` element a rounded corner (25px radius) on the bottom left side**

```CSS
div {
    border-bottom-left-radius: 25px;
}
```

16. **Remove the transparency/opacity of the `<img>` element when the user hovers over it**

```CSS
img {
    opacity: 0.5;
    transition: opacity 0.3s;
}
img:hover {
    opacity: 1;
}
```

17. **Position the `<div>` element all the way to the right using absolute positioning**

```CSS
div {
    position: absolute;
    right: 0;
}
```

18. **Add a scrollbar to the `<div>` element**

```CSS
div {
    overflow: auto;
    width: 200px;
    height: 100px;
}
```

19. **Set a linear gradient background for the `<div>` element**

```CSS
div {
    background: linear-gradient(to bottom, white, red, blue, green);
}
```

20. **Rotate the `<div>` element 45 degrees**

```CSS
div {
    transform: rotate(45deg);
}
```

### Additional Try Outs

1.

```HTML
<html lang="en">
<head>
    <title>Div Rows and Columns</title>
    <style>
        .container {
            display: flex;
            flex-wrap: wrap;
        }
        .item {
            flex: 1 1 33%;
            height: 100px;
            background-color: lightblue;
            margin: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="item"></div>
        <div class="item"></div>
        <div class="item"></div>
    </div>
</body>
</html>
```

2.

```HTML
<html lang="en">
<head>
    <title>Regions Example</title>
    <style>
        .container {
            display: grid;
            grid-template-columns: 1fr 2fr;
            grid-template-rows: 100px 100px;
        }
        .item1 { background-color: lightblue; }
        .item2 { background-color: lightgreen; }
        .item3 { background-color: lightcoral; }
        .item4 { background-color: lightgoldenrodyellow; }
    </style>
</head>
<body>
    <div class="container">
        <div class="item1"></div>
        <div class="item2"></div>
        <div class="item3"></div>
        <div class="item4"></div>
    </div>
</body>
</html>
```
