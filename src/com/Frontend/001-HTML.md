
## Guvi Zen Tasks done by Name here

1. **Fix the bugs in below snippet**

Original:

```HTML
    <html lang="en">
    <head>
        <title>Document
            <body>
                guvi
        </title>
    </head>
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </body>
    </html>
```

Fixed:

```HTML
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    guvi
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </div>
    </div>
</body>
</html>
```

2. **Try the below one**

Original:

```HTML
<html lang="en">
    <head>
        <title>Document
            <body>
                guvi
    </head>
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </body>
    </html>
```

Fixed:

```HTML
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    guvi
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </div>
    </div>
</body>
</html>
```

---

3. **Design a contact us form with all fields as required.**

```HTML
<html lang="en">
<head>
    <title>Contact Us</title>
</head>
<body>
    <form>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required><br><br>
        
        <label for="message">Message:</label><br>
        <textarea id="message" name="message" required></textarea><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

4. **Use certain HTML elements to display the following in a HTML page.**

```HTML
<html lang="en">
<head>
    <title>Programming and Databases</title>
</head>
<body>
    <ul>
        <li>Programming Language
            <ul>
                <li>JavaScript
                    <ol>
                        <li>Angular</li>
                        <li>React</li>
                        <li>Vue.js</li>
                    </ol>
                </li>
                <li>Python
                    <ol>
                        <li>Django Framework</li>
                        <li>Flask Framework</li>
                    </ol>
                </li>
                <li>Java
                    <ol>
                        <li>Spring</li>
                        <li>Maven</li>
                        <li>Hibernate</li>
                    </ol>
                </li>
            </ul>
        </li>
        <li>Database
            <ul>
                <li>MySQL</li>
                <li>MongoDB</li>
                <li>Cassandra</li>
            </ul>
        </li>
    </ul>
</body>
</html>
```

---

5. **Create an element that helps you to open https://google.com in a separate new tab.**

```HTML
<html lang="en">
<head>
    <title>Open Google</title>
</head>
<body>
    <a href="https://google.com" target="_blank">Open Google</a>
</body>
</html>
```

---

6. **In the form, add two radio buttons with grouping them for employee type (Salaried and own business).**

```HTML
<html lang="en">
<head>
    <title>Employee Type</title>
</head>
<body>
    <form>
        <label for="salaried">Salaried</label>
        <input type="radio" id="salaried" name="employee_type" value="salaried" required>
        
        <label for="business">Own Business</label>
        <input type="radio" id="business" name="employee_type" value="business" required><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

7. **Design form shown in the link.**

```HTML
<html lang="en">
<head>
    <title>Card Form</title>
</head>
<body>
    <form>
        <label for="card_number">Card Number:</label>
        <input type="text" id="card_number" name="card_number" required><br><br>
        
        <label for="expiry_date">Expiry Date:</label>
        <input type="text" id="expiry_date" name="expiry_date" required><br><br>
        
        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required><br><br>
        
        <label for="card_holder_name">Card Holder Name:</label>
        <input type="text" id="card_holder_name" name="card_holder_name" required><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

8. **Use the table tag to design given image.**

```HTML
<html lang="en">
<head>
    <title>Table Design</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>City</th>
        </tr>
        <tr>
            <td>John</td>
            <td>25</td>
            <td>New York</td>
        </tr>
        <tr>
            <td>Jane</td>
            <td>28</td>
            <td>Chicago</td>
        </tr>
        <tr>
            <td>Bob</td>
            <td>22</td>
            <td>San Francisco</td>
        </tr>
    </table>
</body>
</html>
```

---

9. **Write HTML input tags snippet to show default values for all Form elements.**

```HTML
<html lang="en">
<head>
    <title>Form Elements with Default Values</title>
</head>
<body>
    <form>
        <label for="text">Text:</label>
        <input type="text" id="text" name="text" value="Default Text"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="123456"><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="example@mail.com"><br><br>
        
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" value="2024-01-01"><br><br>
        
        <label for="color">Color:</label>
        <input type="color" id="color" name="color" value="#ff0000"><br><br>
        
        <label for="number">Number:</label>
        <input type="number" id="number" name="number" value="10"><br><br>
        
        <label for="range">Range:</label>
        <input type="range" id="range" name="range" value="50"><br><br>
        
        <label for="textarea">Textarea:</label><br>
        <textarea id="textarea" name="textarea">Default Text</textarea><br><br>
        
        <label for="checkbox">Checkbox:</label>
        <input type="checkbox" id="checkbox" name="checkbox" checked><br><br>
        
        <label for="radio">Radio:</label>
        <input type="radio" id="radio" name="radio" checked><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

10. **In your HTML page add the below line and Highlight it without using any CSS.**

```HTML
<html lang="en">
<head>
    <title>Highlight Text</title>
</head>
<body>
    <b>"HTML & CSS is awesome"</b>
</body>
</html>
```

---

11. **Create an HTML page, which should contain all types of input elements.**

```HTML
<html lang="en">
<head>
    <title>All Input Elements</title>
</head>
<body>
    <form>
        <label for="text">Text:</label>
        <input type="text" id="text" name="text"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
        <br>
        <br>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date"><br><br>
        
        <label for="color">Color:</label>
        <input type="color" id="color" name="color"><br><br>
        
        <label for="number">Number:</label>
        <input type="number" id="number" name="number"><br><br>
        
        <label for="range">Range:</label>
        <input type="range" id="range" name="range"><br><br>
        
        <label for="textarea">Textarea:</label><br>
        <textarea id="textarea" name="textarea"></textarea><br><br>
        
        <label for="checkbox">Checkbox:</label>
        <input type="checkbox" id="checkbox" name="checkbox"><br><br>
        
        <label for="radio">Radio:</label>
        <input type="radio" id="radio" name="radio"><br><br>
        
        <label for="file">File:</label>
        <input type="file" id="file" name="file"><br><br>
        
        <label for="hidden">Hidden:</label>
        <input type="hidden" id="hidden" name="hidden" value="hidden"><br><br>
        
        <label for="search">Search:</label>
        <input type="search" id="search" name="search"><br><br>
        
        <label for="tel">Tel:</label>
        <input type="tel" id="tel" name="tel"><br><br>
        
        <label for="url">URL:</label>
        <input type="url" id="url" name="url"><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```
