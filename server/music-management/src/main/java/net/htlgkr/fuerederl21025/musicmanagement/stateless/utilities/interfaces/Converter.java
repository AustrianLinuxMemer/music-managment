package net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities.interfaces;

public interface Converter<T, U> {
    U convertFrom(T object);
    T convertTo(U dto);
}
