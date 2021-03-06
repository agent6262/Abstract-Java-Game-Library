/*
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

import org.ajgl.graphics.UtilAnnotations.GlShaderFunction;
import org.lwjgl.opengl.GL20;

/**
 * This class is designed to represent a shader program in OpenGL.
 *
 * @author Tyler Bucher
 * @see GlShaderFunction
 */
@GlShaderFunction
public class ShaderProgram {

    /**
     * The shader program id.
     */
    public final int id;

    /**
     * Creates a new {@link GL20#glCreateProgram() Shader Program} object.
     */
    public ShaderProgram() {
        id = GL20.glCreateProgram();
    }

    /**
     * @param shader the {@link Shader} to be attached to the {@link ShaderProgram}.
     */
    public void attachShader(Shader shader) {
        GL20.glAttachShader(id, shader.id);
    }

    /**
     * @param shader the {@link Shader} to be detached from the {@link ShaderProgram}.
     */
    public void detachShader(Shader shader) {
        GL20.glDetachShader(id, shader.id);
    }

    /**
     * Links the {@link GL20#glLinkProgram shader program}.
     */
    public void link() {
        GL20.glLinkProgram(id);
    }

    /**
     * Validates the {@link GL20#glValidateProgram shader program}.
     */
    public void validate() {
        GL20.glValidateProgram(id);
    }

    /**
     * @return true if the shader program was compiled false otherwise.
     */
    public boolean verify() {
        int status = GL20.glGetProgrami(id, GL20.GL_LINK_STATUS);

        return status != 0;
    }

    /**
     * Deletes an OpenGL shader program.
     */
    public void deleteProgram() {
        GL20.glDeleteProgram(id);
    }

    @Override
    public void finalize() {
        GL20.glDeleteProgram(id);
    }
}
