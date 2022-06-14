#!/bin/bash
ssh -L 8080:aqua:8080 s289307@helios.cs.ifmo.ru -p 2222 -oHostKeyAlgorithms=+ssh-dss
