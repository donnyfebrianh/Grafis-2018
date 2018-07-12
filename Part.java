package com.project;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Alfonsius Lorensius
 */
public class Part {

    static GLU glu = new GLU();

    static void pipe(GL gl, float diameter, float height) {
        float radius = diameter / 2;
        GLUquadric q = glu.gluNewQuadric();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, height / 2, 0.0f);
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        glu.gluCylinder(q, radius, radius, height, 36, 36);
        gl.glPopMatrix();
        glu.gluDeleteQuadric(q);
    }

    static void cylinder(GL gl, float diameter, float height) {
        glu = new GLU();
        float radius = diameter / 2;
        GLUquadric q = glu.gluNewQuadric();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, height / 2, 0.0f);
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        glu.gluCylinder(q, radius, radius, height, 36, 36);
        glu.gluDisk(q, 0, radius, 36, 36);
        gl.glTranslatef(0.0f, 0.0f, height);
        glu.gluDisk(q, 0, radius, 36, 36);
        gl.glPopMatrix();
        glu.gluDeleteQuadric(q);
    }

    static void cube(GL gl, float diameter, float height) {
        glu = new GLU();
        float radius = diameter / 2;
        GLUquadric q = glu.gluNewQuadric();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, height / 2, 0.0f);
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        glu.gluCylinder(q, radius, radius, height, 4, 4);
        glu.gluDisk(q, 0, radius, 4, 4);
        gl.glTranslatef(0.0f, 0.0f, height);
        glu.gluDisk(q, 0, radius, 4, 4);
        gl.glPopMatrix();
        glu.gluDeleteQuadric(q);
    }

    static void disk(GL gl, float inner, float outer) {
        glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();
        gl.glPushMatrix();
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        glu.gluDisk(q, inner / 2, outer / 2, 36, 36);
        gl.glPopMatrix();
        glu.gluDeleteQuadric(q);
    }

    static void pistonHead(GL gl) {
        gl.glPushMatrix();
        gl.glColor3f(0.85f, 0.85f, 0.85f);
        pipe(gl, 4.0f, 3.0f);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 1.5f, 0.0f);
        gl.glColor3f(0.8f, 0.8f, 0.8f);
        disk(gl, 0.0f, 4.0f);
        gl.glTranslatef(0.0f, -3.0f, 0.0f);
        disk(gl, 3.5f, 4.0f);
        gl.glTranslatef(0.0f, 2.0f, 0.0f);
        disk(gl, 0.0f, 3.5f);
        gl.glTranslatef(0.0f, 0.3f, 0.0f);
        cylinder(gl, 4.01f, 0.2f);
        gl.glTranslatef(0.0f, 0.3f, 0.0f);
        cylinder(gl, 4.01f, 0.2f);
        gl.glPopMatrix();

        gl.glTranslatef(0.0f, -0.5f, 0.0f);
        gl.glColor3f(0.75f, 0.75f, 0.75f);
        pipe(gl, 3.5f, 2.0f);

        gl.glColor3f(0.65f, 0.65f, 0.65f);
        gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        cylinder(gl, 1, 3.5f);
        gl.glPopMatrix();
    }

    static void pistonStem(GL gl) {
        GLUquadric q = glu.gluNewQuadric();
        double[] eqn = {0.75, 0.0, 1.0, 0.0};

        gl.glPushMatrix();
        gl.glClipPlane(GL.GL_CLIP_PLANE0, eqn, 1);
        gl.glEnable(GL.GL_CLIP_PLANE0);

        gl.glPushMatrix();
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        gl.glColor3f(0.85f, 0.85f, 0.85f);
        pipe(gl, 4.0f, 1.5f);
        pipe(gl, 2.5f, 1.5f);
        gl.glColor3f(0.8f, 0.8f, 0.8f);
        gl.glTranslatef(0.0f, 0.75f, 0.0f);
        disk(gl, 2.5f, 4.0f);
        gl.glTranslatef(0.0f, -1.5f, 0.0f);
        disk(gl, 2.5f, 4.0f);
        gl.glPopMatrix();
        gl.glDisable(GL.GL_CLIP_PLANE0);

        gl.glPushMatrix();
        gl.glTranslatef(1.7f, 0.75f, 0.0f);
        feetCube(gl, 1.0f, 1.5f, 1.5f);
        gl.glTranslatef(-3.4f, 0.0f, 0.0f);
        feetCube(gl, 1.0f, 1.5f, 1.5f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 5.0f, 0.0f);
        feetCube(gl, 1.5f, 7.0f, 1.5f);
        gl.glPopMatrix();
        gl.glPopMatrix();
        
        // bawah yahud
        gl.glPushMatrix();
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        gl.glColor3f(0.85f, 0.85f, 0.85f);
        pipe(gl, 4.0f, 1.5f);
        pipe(gl, 2.5f, 1.5f);
        gl.glColor3f(0.8f, 0.8f, 0.8f);
        gl.glTranslatef(0.0f, 0.75f, 0.0f);
        disk(gl, 2.5f, 4.0f);
        gl.glTranslatef(0.0f, -1.5f, 0.0f);
        disk(gl, 2.5f, 4.0f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(1.7f, 0f, 0.0f);
        feetCube(gl, 1.0f, 1.5f, 1.5f);
        gl.glTranslatef(-3.4f, 0.0f, 0.0f);
        feetCube(gl, 1.0f, 1.5f, 1.5f);
        gl.glPopMatrix();
    }

    static void feetCube(GL gl, float rx, float ry, float rz) {
        float x = rx / 2;
        float y = ry / 2;
        float z = rz / 2;
        gl.glPushMatrix();
        gl.glColor3f(0.85f, 0.85f, 0.85f);

        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(-x, y, -z);
        gl.glVertex3f(x, y, -z);
        gl.glVertex3f(x, y, z);
        gl.glVertex3f(-x, y, z);
        gl.glVertex3f(-x, -y, z);
        gl.glVertex3f(-x, -y, -z);
        gl.glEnd();

        gl.glPushMatrix();
        gl.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(-x, y, -z);
        gl.glVertex3f(x, y, -z);
        gl.glVertex3f(x, y, z);
        gl.glVertex3f(-x, y, z);
        gl.glVertex3f(-x, -y, z);
        gl.glVertex3f(-x, -y, -z);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glColor3f(0.8f, 0.8f, 0.8f);
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-x, y, -z);
        gl.glVertex3f(x, y, -z);
        gl.glVertex3f(x, -y, -z);
        gl.glVertex3f(-x, -y, -z);
        gl.glEnd();
        gl.glTranslatef(0.0f, 0.0f, rz);
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-x, y, -z);
        gl.glVertex3f(x, y, -z);
        gl.glVertex3f(x, -y, -z);
        gl.glVertex3f(-x, -y, -z);
        gl.glEnd();
        gl.glPopMatrix();
    }
}
