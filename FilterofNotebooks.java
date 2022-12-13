// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class FilterofNotebooks {
    Set<Notebooks> notebooks;

    public FilterofNotebooks(Set<Notebooks> notebooks) {
        this.notebooks = notebooks;
    }
    public void filter(){
        Integer numberKey = 1;
        Integer minValue = 1;
        Set<Notebooks> filteredNotebooks = new HashSet<>();
        Map<Integer , Integer> filterlist = new HashMap<>();
        boolean end = false;
        Scanner line = new Scanner(System.in,"cp866");
        while(!end){
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.print("Ваш выбор: ");
            boolean next = false;
            while(!next){
                String stecline = line.nextLine();
                try {
                    numberKey = Integer.parseInt(stecline);
                    next = true;
                    if(1 > numberKey || 4 < numberKey){System.out.println("Введите число от 1 до 4: " );next = false;}
             } catch (NumberFormatException nfe)
                {
                    System.out.println("Введенные данные не являются натуральным числом" );
                    next = false;
                }
            }
            if(numberKey == 1)    System.out.print("Выберите минимальный размер ОЗУ (введите 1 - 2000 МБ, 2 - 4000 МБ, 3 - 8000 МБ):");
            else if(numberKey == 2)    System.out.print("Выберите минимальный oбъем ЖД (введите 1 - 500 ГБ, 2 - 1000 ГБ, 3 - 1500 ГБ) :");
            else if(numberKey == 3)    System.out.print("Выберите операционную систему (введите 1 - Windows 10, 2 - Windows 11) :");
            else if(numberKey == 4)    System.out.print("Выберите цвет корпуса (введите 1 - зеленый, 2 - красный, 3 - черный, 4 - белый) :");
            next = false;
            while(!next){
                String stecline = line.nextLine();
                try {
                    minValue = Integer.parseInt(stecline);
                    next = true;
                    if(numberKey == 1 || numberKey == 2 ){
                        if(1 > minValue || 3 < minValue) next = false;}
                    if(numberKey == 3){
                        if(1 > minValue || 2 < minValue) next = false;} 
                    if(numberKey == 4){
                        if(1 > minValue || 4 < minValue) next = false;}   
             } catch (NumberFormatException nfe)
                {
                    System.out.print("Введенные данные не являются натуральным числом Введите новое значение:" );
                    next = false;
                }
            }            
            
            filterlist.put(numberKey, minValue); // Добавляем значение отбора
            

            System.out.print("Желаете ввести еще критерий для отбора - 1, нет - 0 :");
            next = false;
            while(!next){
                String stecline = line.nextLine();
                try {
                    numberKey = Integer.parseInt(stecline);
                    next = true;
                    if(numberKey == 0){end = true;}
             } catch (NumberFormatException nfe)
                {
                    System.out.print("Введенные данные не являются натуральным числом. Введите новое значение:" );
                    next = false;
                }
            }
        }
        line.close();
        // Отбор по критериям поиска
        Set<Integer> setKeys = filterlist.keySet();
        System.out.println(setKeys);
        System.out.println();
        System.out.println(filterlist);
        System.out.println();
        for(Notebooks fillNotebooks : notebooks )
            for(Integer key: setKeys){
               if(key == 1){       // минимальный размер ОЗУ (введите 1 - 2000 МБ, 2 - 4000 МБ, 3 - 8000 МБ)
                   if(filterlist.get(key) == 1)
                        if(fillNotebooks.getOzu() < 2000) continue; // При не совпадении данных пропускаем данный элемент
                    if(filterlist.get(key) == 2)
                        if(fillNotebooks.getOzu() < 4000) continue;
                    if(filterlist.get(key) == 3)
                        if(fillNotebooks.getOzu() < 8000) continue;
               }    
                if(key == 2) {       // минимальный oбъем ЖД (введите 1 - 500 ГБ, 2 - 1000 ГБ, 3 - 1500 ГБ)
                    if(filterlist.get(key) == 1)
                        if(fillNotebooks.getSize_of_hard_drive() < 500) continue; // При не совпадении данных пропускаем данный элемент
                    if(filterlist.get(key) == 2)
                        if(fillNotebooks.getSize_of_hard_drive() < 1000) continue;
                    if(filterlist.get(key) == 3)
                        if(fillNotebooks.getSize_of_hard_drive() < 1500) continue;
                }
                if(key == 3) {     // операционную систему (введите 1 - Windows 10, 2 - Windows 11)
                    if(filterlist.get(key) == 1)
                        if(!fillNotebooks.getOs().equals("Windows 10") ) continue; // При не совпадении данных пропускаем данный элемент
                    if(filterlist.get(key) == 2)
                        if(!fillNotebooks.getOs().equals("Windows 11") ) continue;
                }  

                if(key == 4) {     // цвет корпуса (введите 1 - зеленый, 2 - красный, 3 - черный, 4 - белый)
                    if(filterlist.get(key) == 1)
                        if(! fillNotebooks.getColor().equals("green") ) continue; // При не совпадении данных пропускаем данный элемент
                    if(filterlist.get(key) == 2)
                        if(! fillNotebooks.getColor().equals("red") ) continue;
                    if(filterlist.get(key) == 3)
                        if(! fillNotebooks.getColor().equals("blaсk") ) continue;
                    if(filterlist.get(key) == 4)
                        if(! fillNotebooks.getColor().equals("white") ) continue;
                }    
            filteredNotebooks.add(fillNotebooks); //Если все проверки пройдены успешно то добавляем экземпляр в коллекцию filteredNotebooks
            }    
        notebooks = filteredNotebooks;
    }  
    
    @Override
    public String toString() {
        return "Отфильтрованный список ноутбуков = [" + notebooks + "]";
    }
    
}
