<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Reservas</title>
    </head>

    <body>
        <h1>RESERVAS</h1>

        <div id="reservas_container">

            <div id="selectorFiltrosReservas">

                <button>Mes</button>
                <button>Sede</button>
                <button>Aula</button>

            </div>

            <div>
               <p>Mostrar horario:</p>
            <input type="radio" id="morning" name="horario" value="morning">
            <label for="morning">Mañana</label><br>
            <input type="radio" id="afternoon" name="horario" value="afternoon">
            <label for="afternoon">Tarde</label><br> 
            </div>

            <div id="tablaResultados">
                <table class="calendar1">
                    <thead>
                      <caption>Enero 2021</caption>
                      <tr>
                        <th>Lu</th>
                        <th>Ma</th>
                        <th>Mie</th>
                        <th>Ju</th>
                        <th>Vi</th>
                        <th>Sá</th>
                        <th>Do</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                      </tr>
                      <tr>
                        <td>4</td>
                        <td>5</td>
                        <td>6</td>
                        <td>7</td>
                        <td>8</td>
                        <td>9</td>
                        <td>10</td>
                      </tr>
                      <tr>
                        <td>11</td>
                        <td>12</td>
                        <td>13</td>
                        <td>14</td>
                        <td>15</td>
                        <td>16</td>
                        <td>17</td>
                      </tr>
                      <tr>
                        <td>18</td>
                        <td>19</td>
                        <td>20</td>
                        <td>21</td>
                        <td>22</td>
                        <td>23</td>
                        <td>24</td>
                      </tr>
                      <tr>
                        <td>25</td>
                        <td>26</td>
                        <td>27</td>
                        <td>28</td>
                        <td>29</td>
                        <td>30</td>
                        <td>31</td>
                      </tr>
                    </tbody>
                  </table>


            </div>
            


        </div>


    </body>

    </html>