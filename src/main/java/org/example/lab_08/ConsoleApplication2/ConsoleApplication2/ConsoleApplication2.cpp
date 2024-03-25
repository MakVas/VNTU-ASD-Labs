#include <iostream>

int main() {
    // Пряма адресація
    int variable = 42;
    int* address_direct = &variable;
    setlocale(LC_ALL, "Ukrainian");
    // Статичне зв'язування адрес
    static int static_variable = 10;

    // Динамічне зв'язування адрес
    int* dynamic_variable = new int;

    // Адресація з використанням базового регістру
    int base_register = 0x1000;  // приклад базової адреси
    int offset = 0x10;          // приклад зміщення
    int* address_base_register = reinterpret_cast<int*>(base_register + offset);

    // Індексна адресація
    int array[5] = { 1, 2, 3, 4, 5 };
    int index = 2;
    int* address_index = &array[index];

    // Виводимо інформацію для кожного методу
    std::cout << "Значення змiнної: " << variable << std::endl;
    std::cout << "Адреса змiнної (пряма): " << static_cast<void*>(address_direct) << std::endl;

    std::cout << "Значення статичної змiнної: " << static_variable << std::endl;
    std::cout << "Адреса статичної змiнної: " << &static_variable << std::endl;

    std::cout << "Адреса динамiчної змiнної: " << dynamic_variable << std::endl;

    std::cout << "Адреса з використанням базового регiстру: " << address_base_register << std::endl;

    std::cout << "Значення за iндексом " << index << ": " << *address_index << std::endl;
    std::cout << "Адреса з використанням iндекса: " << address_index << std::endl;

    // Звільняємо пам'ять, виділену для dynamic_variable
    delete dynamic_variable;

    return 0;
}
