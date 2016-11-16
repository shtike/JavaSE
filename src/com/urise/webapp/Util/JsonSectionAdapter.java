package com.urise.webapp.Util;

import com.google.gson.*;

import java.lang.reflect.Type;
import com.urise.webapp.model.Section;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * Created by Admin on 30.10.16.
 */
public class JsonSectionAdapter<T>  implements JsonSerializer<T>, JsonDeserializer<T> {

private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE = "INSTANCE";


    @Override
    public T deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive)jsonObject.get(CLASSNAME);
        String className  = prim.getAsString();

        try {
            Class clazz = Class.forName(className);
            return context.deserialize(jsonObject.get(INSTANCE), clazz);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }

    }

    @Override
    public JsonElement serialize(Object o, Type type, JsonSerializationContext context) {

        JsonObject retValue =new JsonObject();

        retValue.addProperty(CLASSNAME, o.getClass().getName());
        JsonElement elem = context.serialize(o);
        retValue.add(INSTANCE, elem);
        return retValue;
    }
}
