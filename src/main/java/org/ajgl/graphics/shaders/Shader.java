/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Tyler Bucher
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.ajgl.graphics.shaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL20;


/**
 * This class is designed to represent a temporary shader 
 * object that should be loaded by a ShaderProgram.
 * @author Tyler Bucher
 */
public class Shader {
    
    /**
     * Loads a new shader object.
     * @param type - The type of shader.
     * @param path - The path to the shader file.
     * @return The new shader object.
     * @throws IOException
     */
    public static Shader loadShader(int type, String path) throws IOException {
        // Return new shader
        return new Shader(type, Shader.loadShader(path));
    }
    
    /**
     * Loads a shader file into a readable format.
     * @param path - The path to the shader file.
     * @return The readable shader file.
     * @throws IOException
     */
    public static CharSequence loadShader(String path) throws IOException {
        // Initial setup
        StringBuilder shaderSource = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        // Traverse shader file
        String line = "";
        while ((line = reader.readLine()) != null) {
            shaderSource.append(line).append("\n");
        }
        reader.close();
        // return shader source
        return shaderSource;
    }
    
    public final int id; // Shader id as given by OpenGL
    
    /**
     * Creates a new shader object.
     * @param type - The type of shader.
     * @param source - The source of a shader file.
     */
    public Shader(int type, CharSequence source) {
        id = GL20.glCreateShader(type);
        GL20.glShaderSource(id, source);
        GL20.glCompileShader(id);
    }
    
    /**
     * Verify's that the shader was loaded and compiled.
     * @return True if the shade was loaded and compiled false otherwise.
     */
    public boolean verify() {
        int status = GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS);
        
        return status == 0 ? false : true;
    }
    
    /**
     * Deletes the shader.
     */
    public void delete() {
        GL20.glDeleteShader(id);
    }
}
